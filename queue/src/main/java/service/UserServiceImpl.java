package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import util.JsonResult;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;	

	public JsonResult<User> login(User user) {
		// TODO Auto-generated method stub
		JsonResult<User> result = new JsonResult<User>();
		User resultUser = userDao.findUser(user.getAccount());
		if(resultUser==null){
			result.setState(500);
			result.setMessage("账号不存在");
			return result;
		}
		if(!User.getMD5(user.getPassword()).equals(resultUser.getPassword())){
			result.setState(500);
			result.setMessage("密码不正确");
			return result;
		}
		if(!(user.getPermission()==resultUser.getPermission())){
			result.setState(500);
			result.setMessage("身份不匹配");
			return result;
		}
		result.setState(200);
		result.setData(resultUser);
		result.setMessage("登陆成功");
		return result;
	}

	public JsonResult<User> getInfo(String account) {
		JsonResult<User> result = new JsonResult<User>();
		User user = new User();
		user = userDao.findUser(account);	
		if(user == null){
			result.setState(500);
			result.setMessage("查不到信息");
			return result;
		}
		result.setState(200);
		result.setData(user);
		result.setMessage("查询成功");
		return result;
	}

	public JsonResult<User> updateUser(User user) {
		JsonResult<User> result = new JsonResult<User>();
		int num = userDao.updateUser(user);
		if(num==1){
			result.setState(200);			
			result.setMessage("更新成功");
		}else{
			result.setState(500);			
			result.setMessage("更新失败");
		}
		return result;
	}

	public JsonResult<User> findUserByCondition(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonResult<User> addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonResult<User> deleteBatchByAccount(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
