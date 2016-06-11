package com.jhms.service.dianji;

import org.json.JSONObject;

/**
 * @Description 点击量service接口
 * @author liuyang
 * @date:2016-6-10
 */
public interface IDianjiService {
	
	public JSONObject queryDianjiAmountService(String typeNo,String startDate,String endDate);

}
