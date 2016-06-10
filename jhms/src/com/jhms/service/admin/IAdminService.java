package com.jhms.service.admin;

import org.json.JSONObject;

/**
 * @Description 管理员service接口
 * @author liuyang
 * @date:2016-6-10
 */
public interface IAdminService {
	
	//登陆Service接口
	public JSONObject loginService(String name,String pwd);

}
