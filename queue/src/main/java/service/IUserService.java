package service;

import java.util.List;
import java.util.Map;

import entity.User;
import util.JsonResult;

public interface IUserService {
	public JsonResult<User> login(User user);
	
	public JsonResult<User> getInfo(String account);
	
	public JsonResult<User> updateUser(User user);
	
	public JsonResult<User> findUserByCondition(Map map);
	
	public JsonResult<User> addUser(User user);
	
	public JsonResult<User> deleteBatchByAccount(List list);
	
	
}
