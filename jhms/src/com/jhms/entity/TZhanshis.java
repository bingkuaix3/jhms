package com.jhms.entity;

/**
 * TZhanshis entity. @author MyEclipse Persistence Tools
 */

public class TZhanshis implements java.io.Serializable {

	// Fields

	private String fid;
	private String fimage;
	private String furl;

	// Constructors

	/** default constructor */
	public TZhanshis() {
	}

	/** full constructor */
	public TZhanshis(String fimage, String furl) {
		this.fimage = fimage;
		this.furl = furl;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFimage() {
		return this.fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public String getFurl() {
		return this.furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

}