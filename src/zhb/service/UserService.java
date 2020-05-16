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
	 * ��ѯ������������
	 */
	public List<Dorm> dormfindAll();

	/**
	 * ����������Ϣ
	 */
	public void dormsave(Dorm dorm);

	/**
	 * ɾ������
	 * @param id
	 */
	public void delete(Integer[] id);

	
	/**
	 * ���ݻ���
	 * @param d_id
	 * @return
	 */
	public Dorm findById(Integer id);
	
	/**
	 * ���ݻ���
	 * @param d_id
	 * @return
	 */
	public Damagething damfindById(Integer da_id);


	/**
	 * ��ѯ���������Ʒ��Ϣ
	 * @return
	 */
	public List<Damagething> damfindAll();

	/**
	 * ���������Ʒ��Ϣ
	 * @param dam
	 */
	public void damsave(Damagething dam);

	/**
	 * ɾ�������Ʒ��Ϣ
	 * @param da_id
	 */
	public void damdelete(Integer[] da_id);

	/**
	 * ��ѯ������Ϣ
	 * @return
	 */
	public List<Score> scofindAll();

	/**
	 * ����������Ϣ
	 * @param sco
	 */
	public void scosave(Score sco);

	/**
	 * ���ݻ���
	 */
	public Score scofindById(Integer id);

	/**
	 * ɾ��������Ϣ
	 */
	public void scodelete(Integer[] id);

	/**
	 * ��ѯ�ÿ���Ϣ
	 */
	public List<Visitors> visfindAll();

	/*
	 * ����ÿ���Ϣ
	 */
	public void vissave(Visitors vis);

	/**
	 * ���ݻ���
	 */
	public Visitors visfindById(Integer id);

	/**
	 * ɾ���ÿ���Ϣ
	 * @param id
	 */
	public void visdelete(Integer[] id);

	/**
	 * ��¼��Ϣ��֤
	 */
	public User checkUser(String username, String pwd);

	/**
	 * ��ʾ�޹���Ϣ
	 */
	public List<User> userfindAll();

	/**
	 * �޹���Ϣ����
	 */
	public void usersave(User user);

	/**
	 * ���ݻ���
	 */
	public User userfindById(Integer u_id);

	/**
	 * ɾ���޹���Ϣ
	 * @param id
	 */
	public void userdelete(Integer[] u_id);
	
	


}
