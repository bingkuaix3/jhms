package com.jhms.dao.user;

import java.util.List;

import com.jhms.entity.TUsers;
import com.jhms.po.graph.UserAgeAmount;
import com.jhms.po.graph.UserRegisterAmount;
import com.jhms.po.graph.UserSexRatio;
import com.jhms.po.graph.UserSourceRatio;

public interface IUserDao {
	
	public void save(TUsers transientInstance);
	
	public void delete(TUsers persistentInstance);
	
	public TUsers findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TUsers merge(TUsers detachedInstance);
	
	public List<UserRegisterAmount> findRegisterByDate(String startDate, String endDate);
	
	public List<UserSexRatio> findSexByDate(String startDate, String endDate);
	
	public List<UserSourceRatio> findSourceByDate(String startDate, String endDate);
	
	public int findCountByDate(String startDate, String endDate);
	
	public List<UserAgeAmount> findAgeByDate(String startDate, String endDate);

}
