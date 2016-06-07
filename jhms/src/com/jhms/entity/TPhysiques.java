package com.jhms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TPhysiques entity. @author MyEclipse Persistence Tools
 */

public class TPhysiques implements java.io.Serializable {

	// Fields

	private String fid;
	private TDemands TDemands;
	private String fname;
	private String fguanlian;
	private String fintroduce;
	private String freason;
	private String flead;
	private String fcharactor;
	private String fimage;
	private Set TQuestionses = new HashSet(0);
	private Set TChanpinses = new HashSet(0);
	private Set THuanjiepilaoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TPhysiques() {
	}

	/** minimal constructor */
	public TPhysiques(TDemands TDemands, String fname) {
		this.TDemands = TDemands;
		this.fname = fname;
	}

	/** full constructor */
	public TPhysiques(TDemands TDemands, String fname, String fguanlian,
			String fintroduce, String freason, String flead, String fcharactor,
			String fimage, Set TQuestionses, Set TChanpinses,
			Set THuanjiepilaoses) {
		this.TDemands = TDemands;
		this.fname = fname;
		this.fguanlian = fguanlian;
		this.fintroduce = fintroduce;
		this.freason = freason;
		this.flead = flead;
		this.fcharactor = fcharactor;
		this.fimage = fimage;
		this.TQuestionses = TQuestionses;
		this.TChanpinses = TChanpinses;
		this.THuanjiepilaoses = THuanjiepilaoses;
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

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFguanlian() {
		return this.fguanlian;
	}

	public void setFguanlian(String fguanlian) {
		this.fguanlian = fguanlian;
	}

	public String getFintroduce() {
		return this.fintroduce;
	}

	public void setFintroduce(String fintroduce) {
		this.fintroduce = fintroduce;
	}

	public String getFreason() {
		return this.freason;
	}

	public void setFreason(String freason) {
		this.freason = freason;
	}

	public String getFlead() {
		return this.flead;
	}

	public void setFlead(String flead) {
		this.flead = flead;
	}

	public String getFcharactor() {
		return this.fcharactor;
	}

	public void setFcharactor(String fcharactor) {
		this.fcharactor = fcharactor;
	}

	public String getFimage() {
		return this.fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public Set getTQuestionses() {
		return this.TQuestionses;
	}

	public void setTQuestionses(Set TQuestionses) {
		this.TQuestionses = TQuestionses;
	}

	public Set getTChanpinses() {
		return this.TChanpinses;
	}

	public void setTChanpinses(Set TChanpinses) {
		this.TChanpinses = TChanpinses;
	}

	public Set getTHuanjiepilaoses() {
		return this.THuanjiepilaoses;
	}

	public void setTHuanjiepilaoses(Set THuanjiepilaoses) {
		this.THuanjiepilaoses = THuanjiepilaoses;
	}

}