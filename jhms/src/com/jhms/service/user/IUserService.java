package com.jhms.service.user;

import org.json.JSONObject;

/**
 * @Description 用户service接口
 * @author liuyang
 * @date:2016-6-10
 */
public interface IUserService {
	
	public JSONObject queryUserRegisterAmountService(String startDate,String endDate);
	
	public JSONObject queryUserSexRatioService(String startDate,String endDate);
	
	public JSONObject queryUserSourceRatioService(String startDate,String endDate);
	
	public JSONObject queryUserAgeAmountService(String startDate,String endDate);

}
