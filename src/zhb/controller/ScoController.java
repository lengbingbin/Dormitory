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
	 * 查询损耗物品信息(分页查询)
	 * @return
	 */
	@RequestMapping("/scolist")
	@ResponseBody		//用于转换对象为JSON
	public Map<String,Object> damlist(Integer page,Integer rows){
		
		//设置分页参数
		PageHelper.startPage(page,rows);
		//查询所有数据
		List<Score> list = userService.scofindAll();
		//使用PageInfo封装查询结果
		PageInfo<Score> pageInfo = new PageInfo<Score>(list);
		//从PageInfo对象取出查询结果
		//总记录数
		long total = pageInfo.getTotal();
		//当前页数据列表
		List<Score> damList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", damList);
		
		return result;
	}
	
	/**
	 * 保存宿舍数据
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
	 * 数据回显
	 */
	@RequestMapping("/scofindById")
	@ResponseBody
	public Score scofindById(Integer id){
		
		Score sco = userService.scofindById(id);
		return sco;
	}
	
	
	/**
	 * 
	 * 删除损耗物品信息
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
