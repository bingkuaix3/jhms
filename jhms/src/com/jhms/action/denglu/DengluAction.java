package com.jhms.action.denglu;

import org.json.JSONObject;

import com.jhms.entity.TAdmin;
import com.jhms.service.denglu.IDengluService;
import com.opensymphony.xwork2.ActionSupport;

public class DengluAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private IDengluService dengluService;

    //用户数据分析参数
    private String startDate;
    private String endDate;
    
    //返回结果
    private String result;
    
    //查询登陆量
    public String queryDengluDayAmount(){
    	JSONObject jsonResult = dengluService.queryDengluDayAmountService(startDate, endDate);
    	result = jsonResult.toString();
    	return "dengluDayAmount";
    }

	public IDengluService getDengluService() {
		return dengluService;
	}

	public void setDengluService(IDengluService dengluService) {
		this.dengluService = dengluService;
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
