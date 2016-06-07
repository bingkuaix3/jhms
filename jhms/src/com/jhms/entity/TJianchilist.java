package com.jhms.entity;

/**
 * TJianchilist entity. @author MyEclipse Persistence Tools
 */

public class TJianchilist implements java.io.Serializable {

	// Fields

	private String fid;
	private String fbelongJianchi;
	private String ffirstUser;
	private String ffirstContent;
	private String fsecondUser;
	private String fsecondContent;
	private String fthirdUser;
	private String fthirdContent;

	// Constructors

	/** default constructor */
	public TJianchilist() {
	}

	/** full constructor */
	public TJianchilist(String fbelongJianchi, String ffirstUser,
			String ffirstContent, String fsecondUser, String fsecondContent,
			String fthirdUser, String fthirdContent) {
		this.fbelongJianchi = fbelongJianchi;
		this.ffirstUser = ffirstUser;
		this.ffirstContent = ffirstContent;
		this.fsecondUser = fsecondUser;
		this.fsecondContent = fsecondContent;
		this.fthirdUser = fthirdUser;
		this.fthirdContent = fthirdContent;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFbelongJianchi() {
		return this.fbelongJianchi;
	}

	public void setFbelongJianchi(String fbelongJianchi) {
		this.fbelongJianchi = fbelongJianchi;
	}

	public String getFfirstUser() {
		return this.ffirstUser;
	}

	public void setFfirstUser(String ffirstUser) {
		this.ffirstUser = ffirstUser;
	}

	public String getFfirstContent() {
		return this.ffirstContent;
	}

	public void setFfirstContent(String ffirstContent) {
		this.ffirstContent = ffirstContent;
	}

	public String getFsecondUser() {
		return this.fsecondUser;
	}

	public void setFsecondUser(String fsecondUser) {
		this.fsecondUser = fsecondUser;
	}

	public String getFsecondContent() {
		return this.fsecondContent;
	}

	public void setFsecondContent(String fsecondContent) {
		this.fsecondContent = fsecondContent;
	}

	public String getFthirdUser() {
		return this.fthirdUser;
	}

	public void setFthirdUser(String fthirdUser) {
		this.fthirdUser = fthirdUser;
	}

	public String getFthirdContent() {
		return this.fthirdContent;
	}

	public void setFthirdContent(String fthirdContent) {
		this.fthirdContent = fthirdContent;
	}

}