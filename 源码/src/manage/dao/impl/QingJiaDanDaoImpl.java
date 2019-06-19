package manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import manage.dao.QingJiaDanDao;
import manage.model.QingJiaDan;

public class QingJiaDanDaoImpl extends HibernateDaoSupport implements  QingJiaDanDao{
	
	@SuppressWarnings("unchecked")
	public List<QingJiaDan> getAll(String where) {
		return this.getHibernateTemplate().find("from QingJiaDan where 1=1 "+where+" order by id");
	}
	
	public void insertQingJiaDan(QingJiaDan qingjiadan){
		this.getHibernateTemplate().save(qingjiadan);
	}
	
	public void delQingJiaDan(QingJiaDan qingjiadan) {
		this.getHibernateTemplate().delete(qingjiadan);
	}
	
	public void updateQingJiaDan(QingJiaDan qingjiadan) {
		this.getHibernateTemplate().update(qingjiadan);
		
	}

	@SuppressWarnings("unchecked")
	public List<QingJiaDan> selectAllQingJiaDan(final int start,final int limit) {
		return (List<QingJiaDan>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<QingJiaDan> list = session.createQuery("from QingJiaDan  order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectAllQingJiaDanCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from QingJiaDan").get(0);
		return (int)count;
	}

	public QingJiaDan selectQingJiaDan(int id) {
		return this.getHibernateTemplate().get(QingJiaDan.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<QingJiaDan> selectAllQingJiaDanBy(final int start,final int limit,final String keyword) {
		return (List<QingJiaDan>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<QingJiaDan> list = session.createQuery("from QingJiaDan where 1=1 "+keyword+" order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
}
