package manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import manage.dao.SubjectDao;
import manage.model.Subject;

public class SubjectDaoImpl extends HibernateDaoSupport implements  SubjectDao{
	
	@SuppressWarnings("unchecked")
	public List<Subject> getAll(String where) {
		return this.getHibernateTemplate().find("from Subject where 1=1 "+where+" order by id");
	}
	
	public void insertSubject(Subject banji){
		this.getHibernateTemplate().save(banji);
	}
	
	public void delSubject(Subject banji) {
		this.getHibernateTemplate().delete(banji);
	}
	
	public void updateSubject(Subject banji) {
		this.getHibernateTemplate().update(banji);
		
	}

	@SuppressWarnings("unchecked")
	public List<Subject> selectAllSubject(final int start,final int limit) {
		return (List<Subject>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Subject> list = session.createQuery("from Subject  order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectAllSubjectCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Subject").get(0);
		return (int)count;
	}

	public Subject selectSubject(int id) {
		return this.getHibernateTemplate().get(Subject.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Subject> selectAllSubjectBy(final int start,final int limit,final String keyword) {
		return (List<Subject>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Subject> list = session.createQuery("from Subject where 1=1 "+keyword+" order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}
	
}
