package zhb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zhb.pojo.Score;
import zhb.pojo.Visitors;
import zhb.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/dormitory")
public class VisController {
	
	@Resource
	private UserService userService;
	private Map<String,Object> result = new HashMap<String,Object>();
	/**
	 * ��ѯ�����Ʒ��Ϣ(��ҳ��ѯ)
	 * @return
	 */
	@RequestMapping("/vislist")
	@ResponseBody		//����ת������ΪJSON
	public Map<String,Object> vislist(Integer page,Integer rows){
		
		//���÷�ҳ����
		PageHelper.startPage(page,rows);
		//��ѯ��������
		List<Visitors> list = userService.visfindAll();
		//ʹ��PageInfo��װ��ѯ���
		PageInfo<Visitors> pageInfo = new PageInfo<Visitors>(list);
		//��PageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total = pageInfo.getTotal();
		//��ǰҳ�����б�
		List<Visitors> visList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", visList);
		
		return result;
	}
	
	/**
	 * ������������
	 */
	@RequestMapping("/vissave")
	@ResponseBody
	public Map<String,Object> vissave(Visitors vis){		
	
		try {
			
			userService.vissave(vis);
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
	@RequestMapping("/visfindById")
	@ResponseBody
	public Visitors visfindById(Integer id){
		
		Visitors vis = userService.visfindById(id);
		return vis;
	}
	
	
	/**
	 * 
	 * ɾ�������Ʒ��Ϣ
	 */
	@RequestMapping("/visdelete")
	@ResponseBody
	public Map<String,Object> visdelete(Integer[] id){
		
		try {
			userService.visdelete(id);
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
