package com.jhms.entity;

/**
 * TSolutions entity. @author MyEclipse Persistence Tools
 */

public class TSolutions implements java.io.Serializable {

	// Fields

	private String fid;
	private TDemands TDemands;
	private String fbelongPhysique;
	private Integer fscoreUp;
	private Integer fscoreDown;
	private String fchayin;
	private String fbaguan;
	private String faijiu;
	private String ftiefu;
	private String fzuyu;

	// Constructors

	/** default constructor */
	public TSolutions() {
	}

	/** minimal constructor */
	public TSolutions(TDemands TDemands, String fbelongPhysique,
			Integer fscoreUp, Integer fscoreDown) {
		this.TDemands = TDemands;
		this.fbelongPhysique = fbelongPhysique;
		this.fscoreUp = fscoreUp;
		this.fscoreDown = fscoreDown;
	}

	/** full constructor */
	public TSolutions(TDemands TDemands, String fbelongPhysique,
			Integer fscoreUp, Integer fscoreDown, String fchayin,
			String fbaguan, String faijiu, String ftiefu, String fzuyu) {
		this.TDemands = TDemands;
		this.fbelongPhysique = fbelongPhysique;
		this.fscoreUp = fscoreUp;
		this.fscoreDown = fscoreDown;
		this.fchayin = fchayin;
		this.fbaguan = fbaguan;
		this.faijiu = faijiu;
		this.ftiefu = ftiefu;
		this.fzuyu = fzuyu;
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

	public String getFbelongPhysique() {
		return this.fbelongPhysique;
	}

	public void setFbelongPhysique(String fbelongPhysique) {
		this.fbelongPhysique = fbelongPhysique;
	}

	public Integer getFscoreUp() {
		return this.fscoreUp;
	}

	public void setFscoreUp(Integer fscoreUp) {
		this.fscoreUp = fscoreUp;
	}

	public Integer getFscoreDown() {
		return this.fscoreDown;
	}

	public void setFscoreDown(Integer fscoreDown) {
		this.fscoreDown = fscoreDown;
	}

	public String getFchayin() {
		return this.fchayin;
	}

	public void setFchayin(String fchayin) {
		this.fchayin = fchayin;
	}

	public String getFbaguan() {
		return this.fbaguan;
	}

	public void setFbaguan(String fbaguan) {
		this.fbaguan = fbaguan;
	}

	public String getFaijiu() {
		return this.faijiu;
	}

	public void setFaijiu(String faijiu) {
		this.faijiu = faijiu;
	}

	public String getFtiefu() {
		return this.ftiefu;
	}

	public void setFtiefu(String ftiefu) {
		this.ftiefu = ftiefu;
	}

	public String getFzuyu() {
		return this.fzuyu;
	}

	public void setFzuyu(String fzuyu) {
		this.fzuyu = fzuyu;
	}

}