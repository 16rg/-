package manage.dao;

import java.util.List;

import manage.model.User;



public interface UserDao  {
	
	public List<User> getAll(String where);
	
	public void delUser(User user);
	
	public void insertUser(User user);
	
	public User selectUserByusername(String username);
	
	public User selectUserbByusernameByPassword(String username,String password);
	
	public List<User> selectAllUser(final int start, final int limit);
	
	public int selectAllUserCount();
	
	public void updateUser(User user);
	
	public User selectUser(int id);
	
	public List<User> selectAllUserByusername(final int start,final int limit,final String keyword);
	public List<User> selectAllUserBy(final int start,final int limit,final String keyword);
	
}
