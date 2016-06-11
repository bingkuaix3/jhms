package com.jhms.dao.dianji;

import java.util.List;

import com.jhms.entity.Dianji;
import com.jhms.po.graph.DianjiAmount;

public interface IDianjiDao {
	
	public void save(Dianji transientInstance);
	
	public void delete(Dianji persistentInstance);
	
	public Dianji findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public Dianji merge(Dianji detachedInstance);
	
	public List<DianjiAmount> findAmountByDate(String typeNo,String startDate,String endDate);

}
