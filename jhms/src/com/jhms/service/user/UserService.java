package com.jhms.service.user;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhms.dao.user.IUserDao;
import com.jhms.po.graph.UserAgeAmount;
import com.jhms.po.graph.UserRegisterAmount;
import com.jhms.po.graph.UserSexRatio;
import com.jhms.po.graph.UserSourceRatio;
import com.jhms.utils.RateUtil;

/**
 * @Description 用户service类
 * @author liuyang
 * @date:2016-6-10
 */
public class UserService implements IUserService{

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	private IUserDao userDao;
	
	/**
	 * @Description 查询用户注册量数据service
	 * @author  liuyang
	 * @param String startDate
	 * @param String endDate
	 * @return json
	 */
	public JSONObject queryUserRegisterAmountService(String startDate,String endDate){
		log.debug("开始查询用户注册量数据service");
		JSONObject jsonResult = new JSONObject();
		try{
			List<UserRegisterAmount> list = userDao.findRegisterByDate(startDate, endDate);
			if(list != null){
				jsonResult.put("state", "success");
				JSONObject jsonList = new JSONObject();
				for(UserRegisterAmount l :list){
					JSONObject jsonL = new JSONObject();
					jsonL.put("registerDate", l.getRegisterDate());
					jsonL.put("registerAmount", l.getRegisterAmount());
					jsonList.put("data", jsonL);
				}
				jsonResult.put("list", jsonList);
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("查询用户注册量数据service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("查询用户注册量数据service报错：",e);
		}
		return jsonResult;
	}

	/**
	 * @Description 查询用户性别比例数据service
	 * @author  liuyang
	 * @param String startDate
	 * @param String endDate
	 * @return json
	 */
	public JSONObject queryUserSexRatioService(String startDate,String endDate){
		log.debug("开始查询用户性别比例数据service");
		JSONObject jsonResult = new JSONObject();
		try{
			List<UserSexRatio> list = userDao.findSexByDate(startDate, endDate);
			int count = userDao.findCountByDate(startDate, endDate);
			RateUtil rate = new RateUtil();
			if(list != null){
				jsonResult.put("state", "success");
				JSONObject jsonList = new JSONObject();
				for(UserSexRatio l :list){
					JSONObject jsonL = new JSONObject();
					switch(l.getSexType()){
					case "0":
						jsonL.put("sexType", "未知");
						jsonL.put("sexAmount", rate.getRate(l.getSexAmount(), count));
						jsonList.put("data", jsonL);
						break;
					case "1":
						jsonL.put("sexType", "男");
						jsonL.put("sexAmount", rate.getRate(l.getSexAmount(), count));
						jsonList.put("data", jsonL);
						break;
					case "2":
						jsonL.put("sexType", "女");
						jsonL.put("sexAmount", rate.getRate(l.getSexAmount(), count));
						jsonList.put("data", jsonL);
						break;
					}
				}
				jsonResult.put("list", jsonList);
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("查询用户性别比例数据service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("查询用户性别比例数据service报错：",e);
		}
		return jsonResult;
	}
	
	/**
	 * @Description 查询用户来源比例数据service
	 * @author  liuyang
	 * @param String startDate
	 * @param String endDate
	 * @return json
	 */
	public JSONObject queryUserSourceRatioService(String startDate,String endDate){
		log.debug("开始查询用户来源比例数据service");
		JSONObject jsonResult = new JSONObject();
		try{
			List<UserSourceRatio> list = userDao.findSourceByDate(startDate, endDate);
			int count = userDao.findCountByDate(startDate, endDate);
			RateUtil rate = new RateUtil();
			if(list != null){
				jsonResult.put("state", "success");
				JSONObject jsonList = new JSONObject();
				for(UserSourceRatio l :list){
					JSONObject jsonL = new JSONObject();
					switch(l.getSourceType()){
					case "0":
						jsonL.put("sexType", "游客");
						jsonL.put("sexAmount", rate.getRate(l.getSourceAmount(), count));
						jsonList.put("data", jsonL);
						break;
					case "1":
						jsonL.put("sexType", "手机");
						jsonL.put("sexAmount", rate.getRate(l.getSourceAmount(), count));
						jsonList.put("data", jsonL);
						break;
					case "2":
						jsonL.put("sexType", "QQ");
						jsonL.put("sexAmount", rate.getRate(l.getSourceAmount(), count));
						jsonList.put("data", jsonL);
						break;
					case "3":
						jsonL.put("sexType", "微信");
						jsonL.put("sexAmount", rate.getRate(l.getSourceAmount(), count));
						jsonList.put("data", jsonL);
						break;
					}
				}
				jsonResult.put("list", jsonList);
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("查询用户来源比例数据service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("查询用户来源比例数据service报错：",e);
		}
		return jsonResult;
	}
	
	
	/**
	 * @Description 查询用户年龄数量数据service
	 * @author  liuyang
	 * @param String startDate
	 * @param String endDate
	 * @return json
	 */
	public JSONObject queryUserAgeAmountService(String startDate,String endDate){
		log.debug("开始查询用户年龄数量数据service");
		JSONObject jsonResult = new JSONObject();
		try{
			List<UserAgeAmount> list = userDao.findAgeByDate(startDate, endDate);
			if(list != null){
				jsonResult.put("state", "success");
				JSONObject jsonList = new JSONObject();
				int sum = 0;
				JSONObject jsonL = null;
				
				for(UserAgeAmount l:list){
					if(l.getAge() == 0){
						 sum += l.getAmount();
					}
				}
				jsonL = new JSONObject();	
				jsonL.put("age","未知");
				jsonL.put("amount", sum);
				jsonList.put("data", jsonL);
				
				for(int i=0;i<80;i=i+5){
					sum = 0;
					for(UserAgeAmount l:list){
						if(l.getAge() > i && l.getAge() <= (i+5)){
							 sum += l.getAmount();
						}
					}
					jsonL = new JSONObject();	
					jsonL.put("age", i+"-"+(i+5));
					jsonL.put("amount", sum);
					jsonList.put("data", jsonL);
				}
				 
				jsonResult.put("list", jsonList);
			}
			else{
				jsonResult.put("state", "fail");
			}
			log.debug("查询用户年龄数量数据service成功");
		}catch(Exception e){
			jsonResult.put("state", "fail");
			log.error("查询用户年龄数量数据service报错：",e);
		}
		return jsonResult;
	}
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
