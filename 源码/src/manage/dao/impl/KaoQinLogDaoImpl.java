package manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import manage.dao.KaoQinLogDao;
import manage.model.KaoQinLog;

public class KaoQinLogDaoImpl extends HibernateDaoSupport implements  KaoQinLogDao{
	
	@SuppressWarnings("unchecked")
	public List<KaoQinLog> getAll(String where) {
		return this.getHibernateTemplate().find("from KaoQinLog where 1=1 "+where+" order by id");
		//这些是spring 为 hibernate 提供的方法，简单直接可以沟通数据库。
	}
	
	public void insertKaoQinLog(KaoQinLog kaoqinlog){
		this.getHibernateTemplate().save(kaoqinlog);
		//通过这个方法可以直接来保存对应的内容到数据库
	}
	
	public void delKaoQinLog(KaoQinLog kaoqinlog) {
		this.getHibernateTemplate().delete(kaoqinlog);
		//通过这个方法可以直接删除数据库中对应的内容
	}
	
	public void updateKaoQinLog(KaoQinLog kaoqinlog) {
		this.getHibernateTemplate().update(kaoqinlog);
		//通过这个方法可以直接更新现在的数据库
	}

	@SuppressWarnings("unchecked")
	//这个注解的作用就是 让下面对应的代码里面的警告保持沉默
	public List<KaoQinLog> selectAllKaoQinLog(final int start,final int limit) {
		return (List<KaoQinLog>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<KaoQinLog> list = session.createQuery("from KaoQinLog order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectAllKaoQinLogCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from KaoQinLog").get(0);
		return (int)count;
	}

	public KaoQinLog selectKaoQinLog(int id) {
		return this.getHibernateTemplate().get(KaoQinLog.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<KaoQinLog> selectAllKaoQinLogBy(final int start,final int limit,final String keyword) {
		return (List<KaoQinLog>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<KaoQinLog> list = session.createQuery("from KaoQinLog where 1=1 "+keyword+" order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
}
