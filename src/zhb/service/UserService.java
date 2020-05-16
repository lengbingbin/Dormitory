package zhb.service;

import java.util.List;












import zhb.pojo.Damagething;
import zhb.pojo.Dorm;
import zhb.pojo.Score;
import zhb.pojo.Student;
import zhb.pojo.User;
import zhb.pojo.Viewvis;
import zhb.pojo.Visitors;

public interface UserService {

	/**
	 * 查询宿舍所有数据
	 */
	public List<Dorm> dormfindAll();

	/**
	 * 保存宿舍信息
	 */
	public void dormsave(Dorm dorm);

	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer[] id);

	
	/**
	 * 数据回显
	 * @param d_id
	 * @return
	 */
	public Dorm findById(Integer id);
	
	/**
	 * 数据回显
	 * @param d_id
	 * @return
	 */
	public Damagething damfindById(Integer da_id);


	/**
	 * 查询所有损耗物品信息
	 * @return
	 */
	public List<Damagething> damfindAll();

	/**
	 * 保存损耗物品信息
	 * @param dam
	 */
	public void damsave(Damagething dam);

	/**
	 * 删除损耗物品信息
	 * @param da_id
	 */
	public void damdelete(Integer[] da_id);

	/**
	 * 查询分数信息
	 * @return
	 */
	public List<Score> scofindAll();

	/**
	 * 保存评分信息
	 * @param sco
	 */
	public void scosave(Score sco);

	/**
	 * 数据回显
	 */
	public Score scofindById(Integer id);

	/**
	 * 删除评分信息
	 */
	public void scodelete(Integer[] id);

	/**
	 * 查询访客信息
	 */
	public List<Visitors> visfindAll();

	/*
	 * 保存访客信息
	 */
	public void vissave(Visitors vis);

	/**
	 * 数据回显
	 */
	public Visitors visfindById(Integer id);

	/**
	 * 删除访客信息
	 * @param id
	 */
	public void visdelete(Integer[] id);

	/**
	 * 登录信息验证
	 */
	public User checkUser(String username, String pwd);

	/**
	 * 显示宿管信息
	 */
	public List<User> userfindAll();

	/**
	 * 宿管信息保存
	 */
	public void usersave(User user);

	/**
	 * 数据回显
	 */
	public User userfindById(Integer u_id);

	/**
	 * 删除宿管信息
	 * @param id
	 */
	public void userdelete(Integer[] u_id);
	
	


}
