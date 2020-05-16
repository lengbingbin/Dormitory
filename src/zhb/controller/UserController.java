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
	 * 查询损耗物品信息(分页查询)
	 * @return
	 */
	@RequestMapping("/userlist")
	@ResponseBody		//用于转换对象为JSON
	public Map<String,Object> userlist(Integer page,Integer rows){
		
		//设置分页参数
		PageHelper.startPage(page,rows);
		//查询所有数据
		List<User> list = userService.userfindAll();
		//使用PageInfo封装查询结果
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		//从PageInfo对象取出查询结果
		//总记录数
		long total = pageInfo.getTotal();
		//当前页数据列表
		List<User> damList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", damList);
		
		return result;
	}
	
	/**
	 * 保存宿舍数据
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
	 * 数据回显
	 */
	@RequestMapping("/userfindById")
	@ResponseBody
	public User userfindById(Integer u_id){
		
		User user = userService.userfindById(u_id);
		return user;
	}
	
	
	/**
	 * 
	 * 删除损耗物品信息
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
