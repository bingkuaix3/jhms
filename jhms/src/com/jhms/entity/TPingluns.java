package com.jhms.entity;

import java.sql.Timestamp;

/**
 * TPingluns entity. @author MyEclipse Persistence Tools
 */

public class TPingluns implements java.io.Serializable {

	// Fields

	private String fid;
	private TJianchis TJianchis;
	private TUsers TUsers;
	private Timestamp ftime;
	private String fcontent;

	// Constructors

	/** default constructor */
	public TPingluns() {
	}

	/** minimal constructor */
	public TPingluns(TJianchis TJianchis, TUsers TUsers, Timestamp ftime) {
		this.TJianchis = TJianchis;
		this.TUsers = TUsers;
		this.ftime = ftime;
	}

	/** full constructor */
	public TPingluns(TJianchis TJianchis, TUsers TUsers, Timestamp ftime,
			String fcontent) {
		this.TJianchis = TJianchis;
		this.TUsers = TUsers;
		this.ftime = ftime;
		this.fcontent = fcontent;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public TJianchis getTJianchis() {
		return this.TJianchis;
	}

	public void setTJianchis(TJianchis TJianchis) {
		this.TJianchis = TJianchis;
	}

	public TUsers getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(TUsers TUsers) {
		this.TUsers = TUsers;
	}

	public Timestamp getFtime() {
		return this.ftime;
	}

	public void setFtime(Timestamp ftime) {
		this.ftime = ftime;
	}

	public String getFcontent() {
		return this.fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

}