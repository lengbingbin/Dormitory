package zhb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zhb.pojo.Dorm;
import zhb.pojo.User;
import zhb.service.UserService;

@Controller
@RequestMapping("/dormitory")
public class LoginController {
	
	@Resource
	private UserService userservice;
	private Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * 登录验证
	 * @throws IOException 
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> login(@RequestParam("username")String username,@RequestParam("password")String password) throws IOException{		
			
			User user = userservice.checkUser(username,password);
			if(user!=null&&user.getPassword().equals(password)){
				result.put("success", true);
			}else{
				result.put("success", false);
				result.put("msg","用户名或者密码错误");
			}
				
		return result;
	}
	
}
