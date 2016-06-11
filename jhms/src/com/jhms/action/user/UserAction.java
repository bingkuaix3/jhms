package com.jhms.action.user;

import org.json.JSONObject;

import com.jhms.entity.TAdmin;
import com.jhms.service.admin.IAdminService;
import com.jhms.service.user.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private IUserService userService;

    //用户数据分析参数
    private String startDate;
    private String endDate;
    
    //返回结果
    private String result;
    
    //查询用户注册量
    public String queryUserRegisterAmount(){
    	JSONObject jsonResult = userService.queryUserRegisterAmountService(startDate, endDate);
    	result = jsonResult.toString();
    	return "userRegisterAmount";
    }
    
    //查询用户性别比例
    public String queryUserSexRatio(){
    	JSONObject jsonResult = userService.queryUserSexRatioService(startDate, endDate);
    	result = jsonResult.toString();
    	return "userSexRatio";
    }
    
    //查询用户来源比例
    public String queryUserSourceRatio(){
    	JSONObject jsonResult = userService.queryUserSourceRatioService(startDate, endDate);
    	result = jsonResult.toString();
    	return "userSourceRatio";
    }
    
    //查询用户年龄分布
    public String queryUserAgeAmount(){
    	JSONObject jsonResult = userService.queryUserAgeAmountService(startDate, endDate);
    	result = jsonResult.toString();
    	return "userAgeAmount";
    }
    
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
     
	
}
