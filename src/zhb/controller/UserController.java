package zhb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zhb.pojo.Damagething;
import zhb.pojo.User;
import zhb.service.UserService;

@Controller
@RequestMapping("/dormitory")
public class UserController {

	@Resource
	private UserService userService;
	private Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * ��ѯ�����Ʒ��Ϣ(��ҳ��ѯ)
	 * @return
	 */
	@RequestMapping("/userlist")
	@ResponseBody		//����ת������ΪJSON
	public Map<String,Object> userlist(Integer page,Integer rows){
		
		//���÷�ҳ����
		PageHelper.startPage(page,rows);
		//��ѯ��������
		List<User> list = userService.userfindAll();
		//ʹ��PageInfo��װ��ѯ���
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		//��PageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total = pageInfo.getTotal();
		//��ǰҳ�����б�
		List<User> damList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", damList);
		
		return result;
	}
	
	/**
	 * ������������
	 */
	@RequestMapping("/usersave")
	@ResponseBody
	public Map<String,Object> usersave(User user){		
	
		try {
			
			userService.usersave(user);
			result.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	/**
	 * ���ݻ���
	 */
	@RequestMapping("/userfindById")
	@ResponseBody
	public User userfindById(Integer u_id){
		
		User user = userService.userfindById(u_id);
		return user;
	}
	
	
	/**
	 * 
	 * ɾ�������Ʒ��Ϣ
	 */
	@RequestMapping("/userdelete")
	@ResponseBody
	public Map<String,Object> userdelete(Integer[] u_id){
		
		try {
			userService.userdelete(u_id);
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
