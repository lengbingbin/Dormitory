package zhb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhb.pojo.Damagething;
import zhb.pojo.Dorm;
import zhb.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/dormitory")
public class DamController {

	@Resource
	private UserService userService;
	private Map<String,Object> result = new HashMap<String,Object>();
	/**
	 * ��ѯ�����Ʒ��Ϣ(��ҳ��ѯ)
	 * @return
	 */
	@RequestMapping("/damlist")
	@ResponseBody		//����ת������ΪJSON
	public Map<String,Object> damlist(Integer page,Integer rows){
		
		//���÷�ҳ����
		PageHelper.startPage(page,rows);
		//��ѯ��������
		List<Damagething> list = userService.damfindAll();
		//ʹ��PageInfo��װ��ѯ���
		PageInfo<Damagething> pageInfo = new PageInfo<Damagething>(list);
		//��PageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total = pageInfo.getTotal();
		//��ǰҳ�����б�
		List<Damagething> damList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", damList);
		
		return result;
	}
	
	/**
	 * ������������
	 */
	@RequestMapping("/damsave")
	@ResponseBody
	public Map<String,Object> damsave(Damagething dam){		
	
		try {
			
			userService.damsave(dam);
			result.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", false);
			//�����᲻����ʱ������
			result.put("msg","�����᲻����");
		}
		return result;
	}
	
	/**
	 * ���ݻ���
	 */
	@RequestMapping("/damfindById")
	@ResponseBody
	public Damagething findById(Integer da_id){
		
		Damagething dam = userService.damfindById(da_id);
		return dam;
	}
	
	
	/**
	 * 
	 * ɾ�������Ʒ��Ϣ
	 */
	@RequestMapping("/damdelete")
	@ResponseBody
	public Map<String,Object> damdelete(Integer[] da_id){
		
		try {
			userService.damdelete(da_id);
			result.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
