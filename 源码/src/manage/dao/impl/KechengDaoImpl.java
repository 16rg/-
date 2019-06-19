package manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import manage.dao.KechengDao;
import manage.model.Kecheng;

public class KechengDaoImpl extends HibernateDaoSupport implements  KechengDao{
	
	@SuppressWarnings("unchecked")
	public List<Kecheng> getAll(String where) {
		return this.getHibernateTemplate().find("from Kecheng where 1=1 "+where+" order by id");
	}
	
	public void insertKecheng(Kecheng kecheng){
		this.getHibernateTemplate().save(kecheng);
	}
	
	public void delKecheng(Kecheng kecheng) {
		this.getHibernateTemplate().delete(kecheng);
	}
	
	public void updateKecheng(Kecheng kecheng) {
		this.getHibernateTemplate().update(kecheng);
		
	}

	@SuppressWarnings("unchecked")
	public List<Kecheng> selectAllKecheng(final int start,final int limit) {
		return (List<Kecheng>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kecheng> list = session.createQuery("from Kecheng  order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectAllKechengCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kecheng").get(0);
		return (int)count;
	}

	public Kecheng selectKecheng(int id) {
		return this.getHibernateTemplate().get(Kecheng.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Kecheng> selectAllKechengBy(final int start,final int limit,final String keyword) {
		return (List<Kecheng>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kecheng> list = session.createQuery("from Kecheng where 1=1 "+keyword+" order by kechenglock")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
}
