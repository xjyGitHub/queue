package dao;

import java.util.List;
import java.util.Map;

import entity.Customer;
import entity.Desktype;

public interface CustomerDao {
	
	public Integer addOne(Customer customer);
	
	public List<Customer> findInfo(Map<String, Object> map);
	
	public Integer getWaitNum(Map<String, Object> map); 
	
	public Integer updateStatus(Map<String, Object> map);
	
	public List<Desktype> getDeskNum();
	
	public Integer updateNum(Integer freeDeskNum); 
}
