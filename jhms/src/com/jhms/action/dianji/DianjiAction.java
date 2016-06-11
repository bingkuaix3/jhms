package com.jhms.action.dianji;

import org.json.JSONObject;

import com.jhms.service.dianji.IDianjiService;
import com.opensymphony.xwork2.ActionSupport;

public class DianjiAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
    private IDianjiService dianjiService;

    //点击类别
    private String typeNo;
    //用户数据分析参数
    private String startDate;
    private String endDate;
    
    //返回结果
    private String result;
    
    //查询登陆量
    public String queryDianjiAmount(){
    	JSONObject jsonResult = dianjiService.queryDianjiAmountService(typeNo, startDate, endDate);
    	result = jsonResult.toString();
    	return "dianjiAmount";
    }

 

	public IDianjiService getDianjiService() {
		return dianjiService;
	}



	public void setDianjiService(IDianjiService dianjiService) {
		this.dianjiService = dianjiService;
	}



	public String getTypeNo() {
		return typeNo;
	}



	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
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
