package zhb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhb.pojo.Damagething;
import zhb.pojo.Score;
import zhb.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/dormitory")
public class ScoController {
	@Resource
	private UserService userService;
	private Map<String,Object> result = new HashMap<String,Object>();
	/**
	 * ��ѯ�����Ʒ��Ϣ(��ҳ��ѯ)
	 * @return
	 */
	@RequestMapping("/scolist")
	@ResponseBody		//����ת������ΪJSON
	public Map<String,Object> damlist(Integer page,Integer rows){
		
		//���÷�ҳ����
		PageHelper.startPage(page,rows);
		//��ѯ��������
		List<Score> list = userService.scofindAll();
		//ʹ��PageInfo��װ��ѯ���
		PageInfo<Score> pageInfo = new PageInfo<Score>(list);
		//��PageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total = pageInfo.getTotal();
		//��ǰҳ�����б�
		List<Score> damList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", damList);
		
		return result;
	}
	
	/**
	 * ������������
	 */
	@RequestMapping("/scosave")
	@ResponseBody
	public Map<String,Object> damsave(Score sco){		
	
		try {
			
			userService.scosave(sco);
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
	@RequestMapping("/scofindById")
	@ResponseBody
	public Score scofindById(Integer id){
		
		Score sco = userService.scofindById(id);
		return sco;
	}
	
	
	/**
	 * 
	 * ɾ�������Ʒ��Ϣ
	 */
	@RequestMapping("/scodelete")
	@ResponseBody
	public Map<String,Object> damdelete(Integer[] id){
		
		try {
			userService.scodelete(id);
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
