package com.jhms.entity;

/**
 * TQuestions entity. @author MyEclipse Persistence Tools
 */

public class TQuestions implements java.io.Serializable {

	// Fields

	private String fid;
	private TPhysiques TPhysiques;
	private String fbelongDemand;
	private String fcontent;

	// Constructors

	/** default constructor */
	public TQuestions() {
	}

	/** full constructor */
	public TQuestions(TPhysiques TPhysiques, String fbelongDemand,
			String fcontent) {
		this.TPhysiques = TPhysiques;
		this.fbelongDemand = fbelongDemand;
		this.fcontent = fcontent;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public TPhysiques getTPhysiques() {
		return this.TPhysiques;
	}

	public void setTPhysiques(TPhysiques TPhysiques) {
		this.TPhysiques = TPhysiques;
	}

	public String getFbelongDemand() {
		return this.fbelongDemand;
	}

	public void setFbelongDemand(String fbelongDemand) {
		this.fbelongDemand = fbelongDemand;
	}

	public String getFcontent() {
		return this.fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

}