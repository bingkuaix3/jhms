package com.jhms.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TUsers entity. @author MyEclipse Persistence Tools
 */

public class TUsers implements java.io.Serializable {

	// Fields

	private String fuserId;
	private String fid;
	private String fname;
	private String fpwd;
	private String ftype;
	private Integer fage;
	private String fsex;
	private Integer fheight;
	private String fcountry;
	private String fprovince;
	private String fcity;
	private String fhead;
	private Timestamp fcreateTime;
	private Set TPinglunses = new HashSet(0);
	private Set TAdvices = new HashSet(0);
	private Set TJianchises = new HashSet(0);
	private Set dianjis = new HashSet(0);
	private Set TCheckses = new HashSet(0);
	private Set TDengluses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUsers() {
	}

	/** minimal constructor */
	public TUsers(String fid, String fname, String fpwd, String ftype,
			String fhead, Timestamp fcreateTime) {
		this.fid = fid;
		this.fname = fname;
		this.fpwd = fpwd;
		this.ftype = ftype;
		this.fhead = fhead;
		this.fcreateTime = fcreateTime;
	}

	/** full constructor */
	public TUsers(String fid, String fname, String fpwd, String ftype,
			Integer fage, String fsex, Integer fheight, String fcountry,
			String fprovince, String fcity, String fhead,
			Timestamp fcreateTime, Set TPinglunses, Set TAdvices,
			Set TJianchises, Set dianjis, Set TCheckses, Set TDengluses) {
		this.fid = fid;
		this.fname = fname;
		this.fpwd = fpwd;
		this.ftype = ftype;
		this.fage = fage;
		this.fsex = fsex;
		this.fheight = fheight;
		this.fcountry = fcountry;
		this.fprovince = fprovince;
		this.fcity = fcity;
		this.fhead = fhead;
		this.fcreateTime = fcreateTime;
		this.TPinglunses = TPinglunses;
		this.TAdvices = TAdvices;
		this.TJianchises = TJianchises;
		this.dianjis = dianjis;
		this.TCheckses = TCheckses;
		this.TDengluses = TDengluses;
	}

	// Property accessors

	public String getFuserId() {
		return this.fuserId;
	}

	public void setFuserId(String fuserId) {
		this.fuserId = fuserId;
	}

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

	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public Integer getFage() {
		return this.fage;
	}

	public void setFage(Integer fage) {
		this.fage = fage;
	}

	public String getFsex() {
		return this.fsex;
	}

	public void setFsex(String fsex) {
		this.fsex = fsex;
	}

	public Integer getFheight() {
		return this.fheight;
	}

	public void setFheight(Integer fheight) {
		this.fheight = fheight;
	}

	public String getFcountry() {
		return this.fcountry;
	}

	public void setFcountry(String fcountry) {
		this.fcountry = fcountry;
	}

	public String getFprovince() {
		return this.fprovince;
	}

	public void setFprovince(String fprovince) {
		this.fprovince = fprovince;
	}

	public String getFcity() {
		return this.fcity;
	}

	public void setFcity(String fcity) {
		this.fcity = fcity;
	}

	public String getFhead() {
		return this.fhead;
	}

	public void setFhead(String fhead) {
		this.fhead = fhead;
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

	public Set getTAdvices() {
		return this.TAdvices;
	}

	public void setTAdvices(Set TAdvices) {
		this.TAdvices = TAdvices;
	}

	public Set getTJianchises() {
		return this.TJianchises;
	}

	public void setTJianchises(Set TJianchises) {
		this.TJianchises = TJianchises;
	}

	public Set getDianjis() {
		return this.dianjis;
	}

	public void setDianjis(Set dianjis) {
		this.dianjis = dianjis;
	}

	public Set getTCheckses() {
		return this.TCheckses;
	}

	public void setTCheckses(Set TCheckses) {
		this.TCheckses = TCheckses;
	}

	public Set getTDengluses() {
		return this.TDengluses;
	}

	public void setTDengluses(Set TDengluses) {
		this.TDengluses = TDengluses;
	}

}