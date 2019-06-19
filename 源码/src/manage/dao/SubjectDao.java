package manage.dao;

import java.util.List;

import manage.model.Subject;



public interface SubjectDao  {
	
	public List<Subject> getAll(String where);
	
	public void delSubject(Subject banji);
	
	public void insertSubject(Subject banji);
	
	public List<Subject> selectAllSubject(final int start, final int limit);
	
	public int selectAllSubjectCount();
	
	public void updateSubject(Subject banji);
	
	public Subject selectSubject(int id);
	
	public List<Subject> selectAllSubjectBy(final int start,final int limit,final String keyword);
	
}
