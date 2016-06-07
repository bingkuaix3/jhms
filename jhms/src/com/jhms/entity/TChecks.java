package com.jhms.entity;

import java.sql.Timestamp;

/**
 * TChecks entity. @author MyEclipse Persistence Tools
 */

public class TChecks implements java.io.Serializable {

	// Fields

	private String fid;
	private TDemands TDemands;
	private TUsers TUsers;
	private String ffeature;
	private String fmediaId;
	private String fmediaResult;
	private String fscore;
	private Timestamp ftime;
	private String fbelongSolutionId;
	private String fstatus;

	// Constructors

	/** default constructor */
	public TChecks() {
	}

	/** minimal constructor */
	public TChecks(TDemands TDemands, TUsers TUsers, String ffeature,
			String fmediaId, String fscore, Timestamp ftime, String fstatus) {
		this.TDemands = TDemands;
		this.TUsers = TUsers;
		this.ffeature = ffeature;
		this.fmediaId = fmediaId;
		this.fscore = fscore;
		this.ftime = ftime;
		this.fstatus = fstatus;
	}

	/** full constructor */
	public TChecks(TDemands TDemands, TUsers TUsers, String ffeature,
			String fmediaId, String fmediaResult, String fscore,
			Timestamp ftime, String fbelongSolutionId, String fstatus) {
		this.TDemands = TDemands;
		this.TUsers = TUsers;
		this.ffeature = ffeature;
		this.fmediaId = fmediaId;
		this.fmediaResult = fmediaResult;
		this.fscore = fscore;
		this.ftime = ftime;
		this.fbelongSolutionId = fbelongSolutionId;
		this.fstatus = fstatus;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public TDemands getTDemands() {
		return this.TDemands;
	}

	public void setTDemands(TDemands TDemands) {
		this.TDemands = TDemands;
	}

	public TUsers getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(TUsers TUsers) {
		this.TUsers = TUsers;
	}

	public String getFfeature() {
		return this.ffeature;
	}

	public void setFfeature(String ffeature) {
		this.ffeature = ffeature;
	}

	public String getFmediaId() {
		return this.fmediaId;
	}

	public void setFmediaId(String fmediaId) {
		this.fmediaId = fmediaId;
	}

	public String getFmediaResult() {
		return this.fmediaResult;
	}

	public void setFmediaResult(String fmediaResult) {
		this.fmediaResult = fmediaResult;
	}

	public String getFscore() {
		return this.fscore;
	}

	public void setFscore(String fscore) {
		this.fscore = fscore;
	}

	public Timestamp getFtime() {
		return this.ftime;
	}

	public void setFtime(Timestamp ftime) {
		this.ftime = ftime;
	}

	public String getFbelongSolutionId() {
		return this.fbelongSolutionId;
	}

	public void setFbelongSolutionId(String fbelongSolutionId) {
		this.fbelongSolutionId = fbelongSolutionId;
	}

	public String getFstatus() {
		return this.fstatus;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

}