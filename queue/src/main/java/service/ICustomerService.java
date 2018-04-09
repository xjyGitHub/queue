package service;

import java.util.List;
import java.util.Map;

import entity.Customer;
import entity.Desktype;
import util.JsonResult;

public interface ICustomerService {
	
public Integer addOne(Customer customer);
	
	public JsonResult<List<Customer>> findInfo(Map map);
	
	public JsonResult<Integer> getWaitNum(); 
	
	public JsonResult<Integer> updateStatus(Map map);
	
	public JsonResult<Desktype> getDeskNum();
	
	public JsonResult<Integer> updateNum(Integer freeDeskNum); 

}
