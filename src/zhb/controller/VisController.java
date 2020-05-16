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
	 * 查询损耗物品信息(分页查询)
	 * @return
	 */
	@RequestMapping("/vislist")
	@ResponseBody		//用于转换对象为JSON
	public Map<String,Object> vislist(Integer page,Integer rows){
		
		//设置分页参数
		PageHelper.startPage(page,rows);
		//查询所有数据
		List<Visitors> list = userService.visfindAll();
		//使用PageInfo封装查询结果
		PageInfo<Visitors> pageInfo = new PageInfo<Visitors>(list);
		//从PageInfo对象取出查询结果
		//总记录数
		long total = pageInfo.getTotal();
		//当前页数据列表
		List<Visitors> visList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", visList);
		
		return result;
	}
	
	/**
	 * 保存宿舍数据
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
	 * 数据回显
	 */
	@RequestMapping("/visfindById")
	@ResponseBody
	public Visitors visfindById(Integer id){
		
		Visitors vis = userService.visfindById(id);
		return vis;
	}
	
	
	/**
	 * 
	 * 删除损耗物品信息
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
