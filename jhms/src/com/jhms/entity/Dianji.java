package com.jhms.entity;

import java.sql.Timestamp;

/**
 * Dianji entity. @author MyEclipse Persistence Tools
 */

public class Dianji implements java.io.Serializable {

	// Fields

	private String fid;
	private TUsers TUsers;
	private String ftype;
	private String ftypeName;
	private Timestamp fdateTime;

	// Constructors

	/** default constructor */
	public Dianji() {
	}

	/** full constructor */
	public Dianji(TUsers TUsers, String ftype, String ftypeName,
			Timestamp fdateTime) {
		this.TUsers = TUsers;
		this.ftype = ftype;
		this.ftypeName = ftypeName;
		this.fdateTime = fdateTime;
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

	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFtypeName() {
		return this.ftypeName;
	}

	public void setFtypeName(String ftypeName) {
		this.ftypeName = ftypeName;
	}

	public Timestamp getFdateTime() {
		return this.fdateTime;
	}

	public void setFdateTime(Timestamp fdateTime) {
		this.fdateTime = fdateTime;
	}

}