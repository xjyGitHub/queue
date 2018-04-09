package service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import entity.Customer;
import entity.Desktype;
import util.DeskNum;
import util.JsonResult;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	/**
	 * 添加一个取号
	 */
	public Integer addOne(Customer customer) {
		customer.setQueueNum(DeskNum.getNum(customer.getDeskcode()));		
		customer.setQueueDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		customer.setStatus(Byte.valueOf("1"));
		return customerDao.addOne(customer);
	}

	public JsonResult<List<Customer>> findInfo(Map map) {
		JsonResult<List<Customer>> result = new JsonResult<List<Customer>>();
		List<Customer> lists = customerDao.findInfo(map);
		result.setData(lists);
		return result;
	}

	public JsonResult<Integer> getWaitNum() {		
		return null;
	}

	public JsonResult<Integer> updateStatus(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonResult<Desktype> getDeskNum() {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonResult<Integer> updateNum(Integer freeDeskNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
