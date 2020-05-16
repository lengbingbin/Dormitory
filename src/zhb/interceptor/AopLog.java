package zhb.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import zhb.pojo.SysLog;
import zhb.service.SysLogService;

@Component
@Aspect
public class AopLog {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private SysLogService syslogservice;
	
	private Date visitTime;
	private Method method;
	private Class clazz;//���ʵ���
	
	//ǰ��֪ͨ ��ȡ��ʼʱ�䣬ִ�е���ʲô����
	@Before("execution(* zhb.controller..*.*(..))")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException{
		visitTime=new Date();//��ǰʱ����ǿ�ʼ���ʵ�ʱ��
		clazz=jp.getTarget().getClass();//����Ҫ���ʵ���
		String methodname = jp.getSignature().getName();//��ȡ���ʵķ���������
		Object[] args = jp.getArgs();
		System.out.println("������!!!!!!!!!!!!!!");
		//��ȡmethod
		if(args==null||args.length==0){
			method=clazz.getMethod(methodname);
			System.out.println("�������𣿣���������������������������");
		}else{
			Class[] classArgs=new Class[args.length];
			//�ѵ㣬bug����
			for(int i=0;i<args.length;i++){
				classArgs[i]=args[i].getClass();
			}
			System.out.println("�����𣿣���������������������������");
			method=clazz.getMethod(methodname,classArgs);
		}
	}
	
	String url="";
	//����֪ͨ
	@After("execution(* zhb.controller..*.*(..))")
	public void doAfter(JoinPoint jp) throws Exception{
		long time = new Date().getTime()-visitTime.getTime();//��ȡ����ʱ��
		
		//��ȡurl
		if(clazz!=null&&method!=null&&clazz!=AopLog.class){
			//��ȡ���ϵ�RequestMapping
			RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
			if(classAnnotation!=null){
				String[] classValue = classAnnotation.value();
				//��ȡ�����ϵ�vlueֵ
				RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
				if(methodAnnotation!=null){
					String[] methodValue = methodAnnotation.value();
					url=classValue[0]+methodValue[0];
				}
			}
		}
		
		//��ȡip��ַ
		String ip  = request.getRemoteAddr();
		
		//��ȡ�û�
		/*SecurityContext context = SecurityContextHolder.getContext();
		User user = (User)context.getAuthentication().getPrincipal();
		String username = user.getName();*/
		
		//�������Ϣ��װ��Syslog����
		SysLog syslog=new SysLog();
		syslog.setExecutionTime(time);
		syslog.setIp(ip);
		syslog.setUrl(url);
		//syslog.setUsername(username);//�û�����ȡ����������Shiro����Spring Security����session����usernameʵ��
		syslog.setVisitTime(visitTime);
		syslog.setMethod("[����]"+clazz.getName()+"  [������]"+method.getName());
		
		//��ɲ���
		syslogservice.save(syslog);
		
	}
	
}
