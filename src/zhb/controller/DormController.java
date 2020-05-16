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

import zhb.pojo.Dorm;
import zhb.service.UserService;

@Controller
@RequestMapping("/dormitory")
public class DormController {
	
	//private QueryRunner q;
	@Resource
	private UserService userService;
	private Map<String,Object> result = new HashMap<String,Object>();
	/**
	 * ��ѯ������Ϣ(��ҳ��ѯ)
	 * @return
	 */
	@RequestMapping("/dormlist")
	@ResponseBody		//����ת������ΪJSON
	public Map<String,Object> dormlist(Integer page,Integer rows){
		
		//���÷�ҳ����
		PageHelper.startPage(page,rows);
		//��ѯ��������
		List<Dorm> list = userService.dormfindAll();
		//ʹ��PageInfo��װ��ѯ���
		PageInfo<Dorm> pageInfo = new PageInfo<Dorm>(list);
		//��PageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total = pageInfo.getTotal();
		//��ǰҳ�����б�
		List<Dorm> dormList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", dormList);
		
		return result;
	}
	
	/**
	 * ������������
	 */
	@RequestMapping("/dormsave")
	@ResponseBody
	public Map<String,Object> dormsave(Dorm dorm){		
	
		try {
			
			userService.dormsave(dorm);
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
	@RequestMapping("/findById")
	@ResponseBody
	public Dorm findById(Integer id){
		
		Dorm dorm = userService.findById(id);
		return dorm;
	}
	
	
	/**
	 * 
	 * ɾ��������Ϣ
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		
		System.out.printf("id:",id);
		try {
			userService.delete(id);
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
