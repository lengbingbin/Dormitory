package zhb.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhb.dao.UserMapper;
import zhb.pojo.Damagething;
import zhb.pojo.Dorm;
import zhb.pojo.Score;
import zhb.pojo.Student;
import zhb.pojo.User;
import zhb.pojo.Viewvis;
import zhb.pojo.Visitors;
import zhb.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	//注入Mapper对象
	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<Dorm> dormfindAll() {
		// TODO Auto-generated method stub
		return userMapper.dormfindAll();
	}

	@Override
	public void dormsave(Dorm dorm) {
		
		if(dorm.getId()!=null){
			//修改
			userMapper.dormupdate(dorm);
		}else{
			userMapper.dormsave(dorm);
		}
	}

	@Override
	public void delete(Integer[] id) {
		// TODO Auto-generated method stub
		userMapper.delete(id);
	}

	@Override
	public Dorm findById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}

	@Override
	public List<Damagething> damfindAll() {
		// TODO Auto-generated method stub
		return userMapper.damfindAll();
	}

	@Override
	public void damsave(Damagething dam) {
		// TODO Auto-generated method stub
		if(dam.getDa_id()!=null){
			//修改
			userMapper.damupdate(dam);
			//System.out.printf("dam:",dam);
		}else{
			userMapper.damsave(dam);
			//userMapper.damupdate(dam);
			//System.out.printf("dam:",dam);
		}
	}

	@Override
	public Damagething damfindById(Integer da_id) {
		// TODO Auto-generated method stub
		 return userMapper.damfindById(da_id);
	}

	@Override
	public void damdelete(Integer[] da_id) {
		// TODO Auto-generated method stub
		userMapper.damdelete(da_id);
	}

	@Override
	public List<Score> scofindAll() {
		// TODO Auto-generated method stub
		return userMapper.scofindAll();
	}

	@Override
	public void scosave(Score sco) {
		// TODO Auto-generated method stub
		if(sco.getId()!=null){
			//修改
			userMapper.scoupdate(sco);
		}else{
			userMapper.scosave(sco);
		}
	}

	@Override
	public Score scofindById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.scofindById(id);
	}

	@Override
	public void scodelete(Integer[] id) {
		// TODO Auto-generated method stub
		userMapper.scodelete(id);
	}

	@Override
	public List<Visitors> visfindAll() {
		// TODO Auto-generated method stub
		return userMapper.visfindAll();
	}

	@Override
	public void vissave(Visitors vis) {
		// TODO Auto-generated method stub
		if(vis.getId()!=null){
			//修改
			userMapper.visupdate(vis);
		}else{
			userMapper.vissave(vis);
		}
	}

	@Override
	public Visitors visfindById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.visfindById(id);
	}

	@Override
	public void visdelete(Integer[] id) {
		userMapper.visdelete(id);	
	}

	@Override
	public User checkUser(String username, String pwd) {
		// TODO Auto-generated method stub
		 return userMapper.checkuser(username,pwd);	
	}

	@Override
	public List<User> userfindAll() {
		// TODO Auto-generated method stub
		return userMapper.userfindAll();
	}

	@Override
	public void usersave(User user) {
		// TODO Auto-generated method stub
		if(user.getu_id()!=null){
			//修改
			userMapper.userupdate(user);
		}else{
			userMapper.usersave(user);
		}		
	}

	@Override
	public User userfindById(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.userfindById(u_id);
	}

	@Override
	public void userdelete(Integer[] u_id) {
		// TODO Auto-generated method stub
		userMapper.userdelete(u_id);	
	}
	
	


}
