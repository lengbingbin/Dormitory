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
	 * 查询宿舍信息(分页查询)
	 * @return
	 */
	@RequestMapping("/dormlist")
	@ResponseBody		//用于转换对象为JSON
	public Map<String,Object> dormlist(Integer page,Integer rows){
		
		//设置分页参数
		PageHelper.startPage(page,rows);
		//查询所有数据
		List<Dorm> list = userService.dormfindAll();
		//使用PageInfo封装查询结果
		PageInfo<Dorm> pageInfo = new PageInfo<Dorm>(list);
		//从PageInfo对象取出查询结果
		//总记录数
		long total = pageInfo.getTotal();
		//当前页数据列表
		List<Dorm> dormList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", dormList);
		
		return result;
	}
	
	/**
	 * 保存宿舍数据
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
	 * 数据回显
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Dorm findById(Integer id){
		
		Dorm dorm = userService.findById(id);
		return dorm;
	}
	
	
	/**
	 * 
	 * 删除宿舍信息
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
