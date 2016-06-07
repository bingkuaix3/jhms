package com.jhms.entity;

/**
 * TChanpins entity. @author MyEclipse Persistence Tools
 */

public class TChanpins implements java.io.Serializable {

	// Fields

	private String fid;
	private TPhysiques TPhysiques;
	private String fname;
	private String fimage;
	private String fzone;
	private Integer famount;
	private String fintroduce;
	private String furl;

	// Constructors

	/** default constructor */
	public TChanpins() {
	}

	/** full constructor */
	public TChanpins(TPhysiques TPhysiques, String fname, String fimage,
			String fzone, Integer famount, String fintroduce, String furl) {
		this.TPhysiques = TPhysiques;
		this.fname = fname;
		this.fimage = fimage;
		this.fzone = fzone;
		this.famount = famount;
		this.fintroduce = fintroduce;
		this.furl = furl;
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

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFimage() {
		return this.fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public String getFzone() {
		return this.fzone;
	}

	public void setFzone(String fzone) {
		this.fzone = fzone;
	}

	public Integer getFamount() {
		return this.famount;
	}

	public void setFamount(Integer famount) {
		this.famount = famount;
	}

	public String getFintroduce() {
		return this.fintroduce;
	}

	public void setFintroduce(String fintroduce) {
		this.fintroduce = fintroduce;
	}

	public String getFurl() {
		return this.furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

}