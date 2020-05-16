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
	private Class clazz;//访问的类
	
	//前置通知 获取开始时间，执行的是什么方法
	@Before("execution(* zhb.controller..*.*(..))")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException{
		visitTime=new Date();//当前时间就是开始访问的时间
		clazz=jp.getTarget().getClass();//具体要访问的类
		String methodname = jp.getSignature().getName();//获取访问的方法的名称
		Object[] args = jp.getArgs();
		System.out.println("进来了!!!!!!!!!!!!!!");
		//获取method
		if(args==null||args.length==0){
			method=clazz.getMethod(methodname);
			System.out.println("进来了吗？？？？？？？？？？？？？？？");
		}else{
			Class[] classArgs=new Class[args.length];
			//难点，bug所在
			for(int i=0;i<args.length;i++){
				classArgs[i]=args[i].getClass();
			}
			System.out.println("进来吗？？？？？？？？？？？？？？？");
			method=clazz.getMethod(methodname,classArgs);
		}
	}
	
	String url="";
	//后置通知
	@After("execution(* zhb.controller..*.*(..))")
	public void doAfter(JoinPoint jp) throws Exception{
		long time = new Date().getTime()-visitTime.getTime();//获取访问时长
		
		//获取url
		if(clazz!=null&&method!=null&&clazz!=AopLog.class){
			//获取类上的RequestMapping
			RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
			if(classAnnotation!=null){
				String[] classValue = classAnnotation.value();
				//获取方法上的vlue值
				RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
				if(methodAnnotation!=null){
					String[] methodValue = methodAnnotation.value();
					url=classValue[0]+methodValue[0];
				}
			}
		}
		
		//获取ip地址
		String ip  = request.getRemoteAddr();
		
		//获取用户
		/*SecurityContext context = SecurityContextHolder.getContext();
		User user = (User)context.getAuthentication().getPrincipal();
		String username = user.getName();*/
		
		//将相关信息封装到Syslog对象
		SysLog syslog=new SysLog();
		syslog.setExecutionTime(time);
		syslog.setIp(ip);
		syslog.setUrl(url);
		//syslog.setUsername(username);//用户名获取，后续可用Shiro或者Spring Security进行session保存username实现
		syslog.setVisitTime(visitTime);
		syslog.setMethod("[类名]"+clazz.getName()+"  [方法名]"+method.getName());
		
		//完成操作
		syslogservice.save(syslog);
		
	}
	
}
