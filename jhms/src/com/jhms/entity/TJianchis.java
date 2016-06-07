package com.jhms.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TJianchis entity. @author MyEclipse Persistence Tools
 */

public class TJianchis implements java.io.Serializable {

	// Fields

	private String fid;
	private TJianchitypes TJianchitypes;
	private TUsers TUsers;
	private Date ftime;
	private String fimage;
	private String fcontent;
	private Timestamp fcreateTime;
	private Set TPinglunses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJianchis() {
	}

	/** minimal constructor */
	public TJianchis(TJianchitypes TJianchitypes, TUsers TUsers, Date ftime,
			String fimage, Timestamp fcreateTime) {
		this.TJianchitypes = TJianchitypes;
		this.TUsers = TUsers;
		this.ftime = ftime;
		this.fimage = fimage;
		this.fcreateTime = fcreateTime;
	}

	/** full constructor */
	public TJianchis(TJianchitypes TJianchitypes, TUsers TUsers, Date ftime,
			String fimage, String fcontent, Timestamp fcreateTime,
			Set TPinglunses) {
		this.TJianchitypes = TJianchitypes;
		this.TUsers = TUsers;
		this.ftime = ftime;
		this.fimage = fimage;
		this.fcontent = fcontent;
		this.fcreateTime = fcreateTime;
		this.TPinglunses = TPinglunses;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public TJianchitypes getTJianchitypes() {
		return this.TJianchitypes;
	}

	public void setTJianchitypes(TJianchitypes TJianchitypes) {
		this.TJianchitypes = TJianchitypes;
	}

	public TUsers getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(TUsers TUsers) {
		this.TUsers = TUsers;
	}

	public Date getFtime() {
		return this.ftime;
	}

	public void setFtime(Date ftime) {
		this.ftime = ftime;
	}

	public String getFimage() {
		return this.fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public String getFcontent() {
		return this.fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public Timestamp getFcreateTime() {
		return this.fcreateTime;
	}

	public void setFcreateTime(Timestamp fcreateTime) {
		this.fcreateTime = fcreateTime;
	}

	public Set getTPinglunses() {
		return this.TPinglunses;
	}

	public void setTPinglunses(Set TPinglunses) {
		this.TPinglunses = TPinglunses;
	}

}