package manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import manage.dao.UserDao;
import manage.model.User;


public class UserDaoImpl extends HibernateDaoSupport implements  UserDao{
	
	@SuppressWarnings("unchecked")
	public List<User> getAll(String where) {
		return this.getHibernateTemplate().find("from User where 1=1 "+where+" order by id");
	}
	
	public void insertUser(User user){
		this.getHibernateTemplate().save(user);
	}
	
	public void delUser(User user) {
		this.getHibernateTemplate().delete(user);
	}
	
	@SuppressWarnings("unchecked")
	public User selectUserByusername(String username) {
		List<User> list = this.getHibernateTemplate().find("from User where username=? and userlock=0",username);
		if(list.size()==0){
			return null;
		}
		return list.get(0);

	}

	@SuppressWarnings("unchecked")
	public User selectUserbByusernameByPassword(String username, String password) {
		List<User> list = this.getHibernateTemplate().find("from User where codenum=? and password = ? and userlock=0",username,password);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}
	
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
		
	}

	@SuppressWarnings("unchecked")
	public List<User> selectAllUser(final int start,final int limit) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<User> list = session.createQuery("from User where userlock=0 order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectAllUserCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from User where userlock=0 ").get(0);
		return (int)count;
	}

	public User selectUser(int id) {
		return this.getHibernateTemplate().get(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> selectAllUserByusername(final int start,final int limit,final String keyword) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<User> list = session.createQuery("from User where  username like ? order by id desc")
				.setParameter(0, "%"+keyword+"%")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<User> selectAllUserBy(final int start,final int limit,final String keyword) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<User> list = session.createQuery("from User where  1=1 "+keyword+" order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
}
