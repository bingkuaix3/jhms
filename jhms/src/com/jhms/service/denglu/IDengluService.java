package com.jhms.service.denglu;

import org.json.JSONObject;

/**
 * @Description 登陆service接口
 * @author liuyang
 * @date:2016-6-10
 */
public interface IDengluService {

	public JSONObject queryDengluDayAmountService(String startDate,String endDate);
}
