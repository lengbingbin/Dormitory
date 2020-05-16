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
	 * ��ѯ������������
	 */
	public List<Dorm> dormfindAll();

	/**
	 * ����������Ϣ
	 * @return
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
	 * ���ݸ���
	 * @param dorm
	 */
	public void dormupdate(Dorm dorm);

	/**
	 * ��ѯ�����Ʒ��Ϣ
	 * @return
	 */
	public List<Damagething> damfindAll();

	/**
	 * �����Ʒ����
	 * @param dam
	 */
	public void damupdate(Damagething dam);

	/**
	 * �����Ʒ����
	 * @param dam
	 */
	public void damsave(Damagething dam);

	/**
	 * ���ݻ���
	 */
	public Damagething damfindById(Integer da_id);

	/**
	 * �����Ʒɾ��
	 */
	public void damdelete(Integer[] da_id);

	/**
	 * ������Ϣ��ѯ
	 */
	public List<Score> scofindAll();

	/**
	 * ���ָ���
	 * @param sco
	 */
	public void scoupdate(Score sco);

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
	 * ɾ������
	 * @param id
	 */
	public void scodelete(Integer[] id);

	/**
	 * ��ѯ�ÿ���Ϣ
	 */
	public List<Visitors> visfindAll();

	/**
	 * ���ݻ���
	 */
	public Visitors visfindById(Integer id);

	
	/**
	 * �ÿ���Ϣɾ�� 
	 */
	public void visdelete(Integer[] id);

	/**
	 * �ÿ����ݸ���
	 */
	public void visupdate(Visitors vis);

	/**
	 * �ÿ����ݱ���
	 */
	public void vissave(Visitors vis);

	/**
	 * ��¼��֤
	 */
	public User checkuser(@Param("username")String username, @Param("password")String password);

	/**
	 * �޹���Ϣ
	 */
	public List<User> userfindAll();

	/**
	 * �޹���Ϣ����
	 */
	public void userupdate(User user);

	/**
	 * �޹���Ϣ����
	 */
	public void usersave(User user);

	/**
	 * ���ݻ���
	 */
	public User userfindById(Integer u_id);

	/**
	 * �޹���Ϣɾ��
	 */
	public void userdelete(Integer[] u_id);
	
	
}
