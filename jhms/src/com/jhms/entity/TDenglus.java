package com.jhms.entity;

import java.sql.Timestamp;

/**
 * TDenglus entity. @author MyEclipse Persistence Tools
 */

public class TDenglus implements java.io.Serializable {

	// Fields

	private String fid;
	private TUsers TUsers;
	private Timestamp ftime;

	// Constructors

	/** default constructor */
	public TDenglus() {
	}

	/** full constructor */
	public TDenglus(TUsers TUsers, Timestamp ftime) {
		this.TUsers = TUsers;
		this.ftime = ftime;
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

}