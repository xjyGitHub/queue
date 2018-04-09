package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
	
	public User findUser(String account);
	
	public Integer updateUser(User user);
	
	public User findUserByCondition(Map map);
	
	public Integer addUser(User user);
	
	public Integer deleteBatchByAccount(List list);	

}
