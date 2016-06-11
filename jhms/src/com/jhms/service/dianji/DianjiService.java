package com.jhms.service.dianji;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhms.dao.dianji.IDianjiDao;
import com.jhms.dao.user.IUserDao;
import com.jhms.po.graph.DengluDayAmount;
import com.jhms.po.graph.DianjiAmount;
import com.jhms.po.graph.UserAgeAmount;
import com.jhms.po.graph.UserRegisterAmount;
import com.jhms.po.graph.UserSexRatio;
import com.jhms.po.graph.UserSourceRatio;
import com.jhms.utils.RateUtil;

/**
 * @Description 点击service类
 * @author liuyang
 * @date:2016-6-10
 */
public class DianjiService implements IDianjiService{

	private static final Logger log = LoggerFactory.getLogger(DianjiService.class);
	
	private IDianjiDao dianjiDao;
	
	/**
	 * @Description 查询点击量数据service
	 * @author  liuyang
	 * @param String typeNo
	 * @param String startDate
	 * @param String endDate
	 * @return json
	 */
	public JSONObject queryDianjiAmountService(String typeNo,String startDate,String endDate){
		log.debug("开始查询点击量数据service");
		JSONObject jsonResult = new JSONObject();
		try{
			List<DianjiAmount> list = dianjiDao.findAmountByDate(typeNo, startDate, endDate);
			if(list != null){
				jsonResult.put("state", "success");
				JSONObject jsonList = new JSONObject();
				for(DianjiAmount l :list){
					JSONObject jsonL = new JSONObject();
					jsonL.put("typeNo", l.getTypeNo());
					jsonL.put("typeName", l.getTypeName());
					jsonL.put("typeAmount", l.getTypeAmount());
					jsonList.put("data", jsonL);
				}
				jsonResult.put("list", jsonList);
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("查询点击量数据service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("查询点击量数据service报错：",e);
		}
		return jsonResult;
	}

	public IDianjiDao getDianjiDao() {
		return dianjiDao;
	}

	public void setDianjiDao(IDianjiDao dianjiDao) {
		this.dianjiDao = dianjiDao;
	}
	
}
