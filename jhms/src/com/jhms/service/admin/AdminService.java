package com.jhms.service.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

import com.jhms.dao.admin.IAdminDao;
import com.jhms.entity.TAdmin;

/**
 * @Description 管理员service类
 * @author liuyang
 * @date:2016-6-10
 */
public class AdminService implements IAdminService{
	
	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	
	private IAdminDao adminDao;
	
	/**
	 * @Description 管理员登陆service
	 * @author  liuyang
	 * @param String name
	 * @param String pwd
	 * @return json
	 */
	public JSONObject loginService(String name,String pwd){
		log.debug("开始执行管理员登陆service");
		JSONObject jsonResult = new JSONObject();
		try{
			TAdmin admin = adminDao.findByNameAndPwd(name, pwd);
			if(admin != null){
				jsonResult.put("state", "success");
				jsonResult.put("name", admin.getFname());
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("执行管理员登陆service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("执行管理员登陆service报错："+e.toString());
		}
		return jsonResult;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	

}
