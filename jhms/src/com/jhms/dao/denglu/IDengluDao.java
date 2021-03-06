package com.jhms.dao.denglu;

import java.util.List;

import com.jhms.entity.TDenglus;
import com.jhms.po.graph.DengluDayAmount;

public interface IDengluDao {
	
	public void save(TDenglus transientInstance);
	
	public void delete(TDenglus persistentInstance);
	
	public TDenglus findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TDenglus merge(TDenglus detachedInstance);
	
	public List<DengluDayAmount> findAmountByDate(String startDate,String endDate);

}
