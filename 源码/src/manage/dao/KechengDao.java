package manage.dao;

import java.util.List;

import manage.model.Kecheng;



public interface KechengDao  {
	
	public List<Kecheng> getAll(String where);
	
	public void delKecheng(Kecheng kecheng);
	
	public void insertKecheng(Kecheng kecheng);
	
	public List<Kecheng> selectAllKecheng(final int start, final int limit);
	
	public int selectAllKechengCount();
	
	public void updateKecheng(Kecheng kecheng);
	
	public Kecheng selectKecheng(int id);
	
	public List<Kecheng> selectAllKechengBy(final int start,final int limit,final String keyword);
	
}
