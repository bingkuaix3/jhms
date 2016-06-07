package com.jhms.entity;

/**
 * TShiyongs entity. @author MyEclipse Persistence Tools
 */

public class TShiyongs implements java.io.Serializable {

	// Fields

	private String fid;
	private Integer fcha;
	private Integer fbaguan;
	private Integer ftiefu;
	private Integer fzuyu;
	private Integer faijiu;

	// Constructors

	/** default constructor */
	public TShiyongs() {
	}

	/** full constructor */
	public TShiyongs(Integer fcha, Integer fbaguan, Integer ftiefu,
			Integer fzuyu, Integer faijiu) {
		this.fcha = fcha;
		this.fbaguan = fbaguan;
		this.ftiefu = ftiefu;
		this.fzuyu = fzuyu;
		this.faijiu = faijiu;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public Integer getFcha() {
		return this.fcha;
	}

	public void setFcha(Integer fcha) {
		this.fcha = fcha;
	}

	public Integer getFbaguan() {
		return this.fbaguan;
	}

	public void setFbaguan(Integer fbaguan) {
		this.fbaguan = fbaguan;
	}

	public Integer getFtiefu() {
		return this.ftiefu;
	}

	public void setFtiefu(Integer ftiefu) {
		this.ftiefu = ftiefu;
	}

	public Integer getFzuyu() {
		return this.fzuyu;
	}

	public void setFzuyu(Integer fzuyu) {
		this.fzuyu = fzuyu;
	}

	public Integer getFaijiu() {
		return this.faijiu;
	}

	public void setFaijiu(Integer faijiu) {
		this.faijiu = faijiu;
	}

}