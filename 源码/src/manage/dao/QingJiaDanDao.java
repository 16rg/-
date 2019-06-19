package manage.dao;

import java.util.List;

import manage.model.QingJiaDan;

public interface QingJiaDanDao  {
	
	public List<QingJiaDan> getAll(String where);
	
	public void delQingJiaDan(QingJiaDan qingjiadan);
	
	public void insertQingJiaDan(QingJiaDan qingjiadan);
	
	public List<QingJiaDan> selectAllQingJiaDan(final int start, final int limit);
	
	public int selectAllQingJiaDanCount();
	
	public void updateQingJiaDan(QingJiaDan qingjiadan);
	
	public QingJiaDan selectQingJiaDan(int id);
	
	public List<QingJiaDan> selectAllQingJiaDanBy(final int start,final int limit,final String keyword);
	
}
