package com.jhms.action.admin;

import net.sf.json.JSONObject;

import com.jhms.entity.TAdmin;
import com.jhms.service.admin.IAdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private IAdminService adminService;
    
    private TAdmin admin;
    
    private String name;
    
    private String pwd;
    
    
    public String login(){
    	JSONObject jsonResult = adminService.loginService(name, pwd);
    	if(jsonResult.get("state").equals("success")){
    		return "success";
    	}
    	else{
    		return "fail";
    	}
    }

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public TAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(TAdmin admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
