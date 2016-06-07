package com.jhms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TJianchitypes entity. @author MyEclipse Persistence Tools
 */

public class TJianchitypes implements java.io.Serializable {

	// Fields

	private String fid;
	private String fname;
	private String fbelongType;
	private Set TJianchises = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJianchitypes() {
	}

	/** minimal constructor */
	public TJianchitypes(String fname, String fbelongType) {
		this.fname = fname;
		this.fbelongType = fbelongType;
	}

	/** full constructor */
	public TJianchitypes(String fname, String fbelongType, Set TJianchises) {
		this.fname = fname;
		this.fbelongType = fbelongType;
		this.TJianchises = TJianchises;
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

	public String getFbelongType() {
		return this.fbelongType;
	}

	public void setFbelongType(String fbelongType) {
		this.fbelongType = fbelongType;
	}

	public Set getTJianchises() {
		return this.TJianchises;
	}

	public void setTJianchises(Set TJianchises) {
		this.TJianchises = TJianchises;
	}

}