package manage.dao;

import java.util.List;

import manage.model.KaoQinLog;


public interface KaoQinLogDao  {
	
	public List<KaoQinLog> getAll(String where);
	
	public void delKaoQinLog(KaoQinLog kaoqinlog);
	
	public void insertKaoQinLog(KaoQinLog kaoqinlog);
	
	public List<KaoQinLog> selectAllKaoQinLog(final int start, final int limit);
	
	public int selectAllKaoQinLogCount();
	
	public void updateKaoQinLog(KaoQinLog kaoqinlog);
	
	public KaoQinLog selectKaoQinLog(int id);
	
	public List<KaoQinLog> selectAllKaoQinLogBy(final int start,final int limit,final String keyword);
	
}
