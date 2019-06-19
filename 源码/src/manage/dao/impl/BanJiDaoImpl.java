package manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import manage.dao.BanJiDao;
import manage.model.BanJi;

public class BanJiDaoImpl extends HibernateDaoSupport implements  BanJiDao{
	
	@SuppressWarnings("unchecked")
	public List<BanJi> getAll(String where) {
		return this.getHibernateTemplate().find("from BanJi where 1=1 "+where+" order by id");
	}
	
	public void insertBanJi(BanJi banji){
		this.getHibernateTemplate().save(banji);
	}
	
	public void delBanJi(BanJi banji) {
		this.getHibernateTemplate().delete(banji);
	}
	
	public void updateBanJi(BanJi banji) {
		this.getHibernateTemplate().update(banji);
		
	}

	@SuppressWarnings("unchecked")
	public List<BanJi> selectAllBanJi(final int start,final int limit) {
		return (List<BanJi>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<BanJi> list = session.createQuery("from BanJi  order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectAllBanJiCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from BanJi").get(0);
		return (int)count;
	}

	public BanJi selectBanJi(int id) {
		return this.getHibernateTemplate().get(BanJi.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<BanJi> selectAllBanJiBy(final int start,final int limit,final String keyword) {
		return (List<BanJi>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<BanJi> list = session.createQuery("from BanJi where 1=1 "+keyword+" order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
}
