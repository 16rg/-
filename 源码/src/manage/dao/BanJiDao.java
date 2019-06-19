package manage.dao;

import java.util.List;

import manage.model.BanJi;


public interface BanJiDao  {
	
	public List<BanJi> getAll(String where);
	
	public void delBanJi(BanJi banji);
	
	public void insertBanJi(BanJi banji);
	
	public List<BanJi> selectAllBanJi(final int start, final int limit);
	
	public int selectAllBanJiCount();
	
	public void updateBanJi(BanJi banji);
	
	public BanJi selectBanJi(int id);
	
	public List<BanJi> selectAllBanJiBy(final int start,final int limit,final String keyword);
	
}
