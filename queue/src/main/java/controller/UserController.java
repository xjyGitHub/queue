package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import service.IUserService;
import util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 登录功能 
	 */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public JsonResult<User> doLogin(HttpServletResponse response,HttpServletRequest request,String account,String password,Byte permission){
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setPermission(permission);	
		JsonResult<User> result = userService.login(user);
		if(result.getState()==200){	
			HttpSession session = request.getSession();
			session.setAttribute("user",result.getData());
			session.setMaxInactiveInterval(60*30);//30分钟
		}
		return result;
	};
	
	/**
	 * 重定向到管理员管理界面
	 */
	@RequestMapping(value="/toAdminView.do")
	public void toAdminView(HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.sendRedirect("/queue/adminview/adminView.jsp");
	};	
	
	/**	 
	 * 重定向到服务员管理界面
	 */
	@RequestMapping(value="/toWaiterView.do")
	public void toWaiterView(HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.sendRedirect("/queue/waiterview/waiterView.jsp");
	};
	
	/**	 
	 * 重定向到登录界面
	 */
	@RequestMapping(value="/toLoginView.do")
	public void toLoginView(HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.sendRedirect("/queue/index.html");
	};
	
	/**	 
	 * 重定向到顾客取号界面
	 */
	@RequestMapping(value="/toCustomerView.do")	
	public void toCustomerView(HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.sendRedirect("/queue/customerIndex.html");
	};
	
	/**
	 * 退出
	 */
	@RequestMapping(value="/exit.do")
	public void exit(HttpServletResponse response,HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession();		
		session.removeAttribute("user");		
		response.sendRedirect("/queue/user/toLoginView.do");
	};
	
	/**
	 * 获取个人信息
	 */
	@RequestMapping(value="/getInfo.do")
	@ResponseBody
	public JsonResult<User> getInfo(HttpServletResponse response,HttpServletRequest request,String account) throws IOException{
		return userService.getInfo(account);
	};
	
	/**
	 * 修改个人信息
	 */
	@RequestMapping(value="/updateUser.do")
	@ResponseBody
	public JsonResult<User> updateUser(HttpServletResponse response,HttpServletRequest request,User user) throws IOException{
		user.setName(new String(user.getName().getBytes("ISO-8859-1"),"utf-8"));		
		return userService.updateUser(user);
	};
	
	/**
	 * 管理员查询服务员信息 
	 */
	@RequestMapping(value="/findUserByCondition.do")
	@ResponseBody
	public JsonResult<User> findUserByCondition(Map map) {		
		return userService.findUserByCondition(map);
	}
	
	/**
	 * 管理员添加服务员信息
	 */
	@RequestMapping(value="/addUser.do")
	@ResponseBody
	public JsonResult<User> addUser(User user) {
		user.setPassword(User.getMD5(user.getPassword()));
		return userService.addUser(user);
	}

	/**
	 * 管理员批量删除服务员信息
	 */
	@RequestMapping(value="/deleteBatchByAccount.do")
	@ResponseBody
	public JsonResult<User> deleteBatchByAccount(List<User> list) {		
		return userService.deleteBatchByAccount(list);
	}

}
