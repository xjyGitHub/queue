package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Customer;
import service.ICustomerService;
import util.JsonResult;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/getNum.do")
	@ResponseBody
	public JsonResult<Customer> getNum() {
		
		return null;
	}

}
