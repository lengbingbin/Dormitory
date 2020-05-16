package zhb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zhb.pojo.Damagething;
import zhb.pojo.Dorm;
import zhb.pojo.Score;
import zhb.pojo.User;
import zhb.pojo.Visitors;

public interface UserMapper {

	/**
	 * 查询宿舍所有数据
	 */
	public List<Dorm> dormfindAll();

	/**
	 * 保存宿舍信息
	 * @return
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
	 * 数据更新
	 * @param dorm
	 */
	public void dormupdate(Dorm dorm);

	/**
	 * 查询损耗物品信息
	 * @return
	 */
	public List<Damagething> damfindAll();

	/**
	 * 损耗物品更新
	 * @param dam
	 */
	public void damupdate(Damagething dam);

	/**
	 * 损耗物品保存
	 * @param dam
	 */
	public void damsave(Damagething dam);

	/**
	 * 数据回显
	 */
	public Damagething damfindById(Integer da_id);

	/**
	 * 损耗物品删除
	 */
	public void damdelete(Integer[] da_id);

	/**
	 * 分数信息查询
	 */
	public List<Score> scofindAll();

	/**
	 * 评分更新
	 * @param sco
	 */
	public void scoupdate(Score sco);

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
	 * 删除数据
	 * @param id
	 */
	public void scodelete(Integer[] id);

	/**
	 * 查询访客信息
	 */
	public List<Visitors> visfindAll();

	/**
	 * 数据回显
	 */
	public Visitors visfindById(Integer id);

	
	/**
	 * 访客信息删除 
	 */
	public void visdelete(Integer[] id);

	/**
	 * 访客数据更新
	 */
	public void visupdate(Visitors vis);

	/**
	 * 访客数据保存
	 */
	public void vissave(Visitors vis);

	/**
	 * 登录验证
	 */
	public User checkuser(@Param("username")String username, @Param("password")String password);

	/**
	 * 宿管信息
	 */
	public List<User> userfindAll();

	/**
	 * 宿管信息更新
	 */
	public void userupdate(User user);

	/**
	 * 宿管信息保存
	 */
	public void usersave(User user);

	/**
	 * 数据回显
	 */
	public User userfindById(Integer u_id);

	/**
	 * 宿管信息删除
	 */
	public void userdelete(Integer[] u_id);
	
	
}
