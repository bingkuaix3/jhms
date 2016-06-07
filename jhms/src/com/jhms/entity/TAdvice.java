package com.jhms.entity;

import java.sql.Timestamp;

/**
 * TAdvice entity. @author MyEclipse Persistence Tools
 */

public class TAdvice implements java.io.Serializable {

	// Fields

	private String fid;
	private TUsers TUsers;
	private Timestamp ftime;
	private String fcontent;

	// Constructors

	/** default constructor */
	public TAdvice() {
	}

	/** full constructor */
	public TAdvice(TUsers TUsers, Timestamp ftime, String fcontent) {
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