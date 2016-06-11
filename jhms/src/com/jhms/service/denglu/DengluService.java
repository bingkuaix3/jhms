package com.jhms.service.denglu;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhms.dao.denglu.IDengluDao;
import com.jhms.po.graph.DengluDayAmount;
import com.jhms.po.graph.UserRegisterAmount;

/**
 * @Description 登陆service类
 * @author liuyang
 * @date:2016-6-10
 */
public class DengluService implements IDengluService {

	private static final Logger log = LoggerFactory
			.getLogger(DengluService.class);

	private IDengluDao dengluDao;

	/**
	 * @Description 查询登陆数据service
	 * @author liuyang
	 * @param String
	 *            startDate
	 * @param String
	 *            endDate
	 * @return json
	 */
	public JSONObject queryDengluDayAmountService(String startDate,String endDate){
		log.debug("开始查询登陆数据service");
		JSONObject jsonResult = new JSONObject();
		try{
			List<DengluDayAmount> list = dengluDao.findAmountByDate(startDate, endDate);
			if(list != null){
				jsonResult.put("state", "success");
				List<DengluDayAmount> initList = new ArrayList();
				for(int i=0;i<24;i++){
					DengluDayAmount temp = new DengluDayAmount();
					temp.setHr(i+"");
					temp.setAmount(0);
					initList.add(temp);
				}
				JSONObject jsonList = new JSONObject();
				for(DengluDayAmount m:initList){
					for(DengluDayAmount n :list){
						if(m.getHr().equals(n.getHr())){
							m.setAmount(n.getAmount());
						}
					}
				}
				for(DengluDayAmount l :initList){
					JSONObject jsonL = new JSONObject();	
					jsonL.put("hour", l.getHr());
					jsonL.put("amount", l.getAmount());
					jsonList.put("data", jsonL);
				}
				jsonResult.put("list", jsonList);
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("查询登陆数据service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("查询登陆数据service报错：",e);
		}
		return jsonResult;
	}

	public IDengluDao getDengluDao() {
		return dengluDao;
	}

	public void setDengluDao(IDengluDao dengluDao) {
		this.dengluDao = dengluDao;
	}

}
