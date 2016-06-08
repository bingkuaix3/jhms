package com.jhms.dao.huanjie;

import java.util.List;

import com.jhms.entity.THuanjiepilaos;

public interface IHuanjiepilaoDao {
	
	public void save(THuanjiepilaos transientInstance);
	
	public void delete(THuanjiepilaos persistentInstance);
	
	public THuanjiepilaos findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public THuanjiepilaos merge(THuanjiepilaos detachedInstance);

}
