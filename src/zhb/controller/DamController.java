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
	 * 查询损耗物品信息(分页查询)
	 * @return
	 */
	@RequestMapping("/damlist")
	@ResponseBody		//用于转换对象为JSON
	public Map<String,Object> damlist(Integer page,Integer rows){
		
		//设置分页参数
		PageHelper.startPage(page,rows);
		//查询所有数据
		List<Damagething> list = userService.damfindAll();
		//使用PageInfo封装查询结果
		PageInfo<Damagething> pageInfo = new PageInfo<Damagething>(list);
		//从PageInfo对象取出查询结果
		//总记录数
		long total = pageInfo.getTotal();
		//当前页数据列表
		List<Damagething> damList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", damList);
		
		return result;
	}
	
	/**
	 * 保存宿舍数据
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
			//当宿舍不存在时，报错
			result.put("msg","该宿舍不存在");
		}
		return result;
	}
	
	/**
	 * 数据回显
	 */
	@RequestMapping("/damfindById")
	@ResponseBody
	public Damagething findById(Integer da_id){
		
		Damagething dam = userService.damfindById(da_id);
		return dam;
	}
	
	
	/**
	 * 
	 * 删除损耗物品信息
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
