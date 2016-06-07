package com.jhms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TDemands entity. @author MyEclipse Persistence Tools
 */

public class TDemands implements java.io.Serializable {

	// Fields

	private String fid;
	private String fname;
	private String fsecondName;
	private Set TPhysiqueses = new HashSet(0);
	private Set TCheckses = new HashSet(0);
	private Set TSolutionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TDemands() {
	}

	/** minimal constructor */
	public TDemands(String fname, String fsecondName) {
		this.fname = fname;
		this.fsecondName = fsecondName;
	}

	/** full constructor */
	public TDemands(String fname, String fsecondName, Set TPhysiqueses,
			Set TCheckses, Set TSolutionses) {
		this.fname = fname;
		this.fsecondName = fsecondName;
		this.TPhysiqueses = TPhysiqueses;
		this.TCheckses = TCheckses;
		this.TSolutionses = TSolutionses;
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

	public String getFsecondName() {
		return this.fsecondName;
	}

	public void setFsecondName(String fsecondName) {
		this.fsecondName = fsecondName;
	}

	public Set getTPhysiqueses() {
		return this.TPhysiqueses;
	}

	public void setTPhysiqueses(Set TPhysiqueses) {
		this.TPhysiqueses = TPhysiqueses;
	}

	public Set getTCheckses() {
		return this.TCheckses;
	}

	public void setTCheckses(Set TCheckses) {
		this.TCheckses = TCheckses;
	}

	public Set getTSolutionses() {
		return this.TSolutionses;
	}

	public void setTSolutionses(Set TSolutionses) {
		this.TSolutionses = TSolutionses;
	}

}