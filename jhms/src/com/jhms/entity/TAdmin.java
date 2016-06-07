package com.jhms.entity;

/**
 * TAdmin entity. @author MyEclipse Persistence Tools
 */

public class TAdmin implements java.io.Serializable {

	// Fields

	private String fid;
	private String fname;
	private String fpwd;

	// Constructors

	/** default constructor */
	public TAdmin() {
	}

	/** full constructor */
	public TAdmin(String fname, String fpwd) {
		this.fname = fname;
		this.fpwd = fpwd;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFpwd() {
		return this.fpwd;
	}

	public void setFpwd(String fpwd) {
		this.fpwd = fpwd;
	}

}