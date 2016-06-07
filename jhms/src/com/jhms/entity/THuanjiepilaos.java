package com.jhms.entity;

/**
 * THuanjiepilaos entity. @author MyEclipse Persistence Tools
 */

public class THuanjiepilaos implements java.io.Serializable {

	// Fields

	private String fid;
	private TPhysiques TPhysiques;
	private String ftypeb;
	private String ftypebName;
	private String ftypem;
	private String ftypemName;
	private String ftypes;
	private String ftypesName;
	private String fimg;
	private String ftitle1;
	private String fcontent1;
	private String ftitle2;
	private String fcontent2;
	private String ftitle3;
	private String fcontent3;

	// Constructors

	/** default constructor */
	public THuanjiepilaos() {
	}

	/** full constructor */
	public THuanjiepilaos(TPhysiques TPhysiques, String ftypeb,
			String ftypebName, String ftypem, String ftypemName, String ftypes,
			String ftypesName, String fimg, String ftitle1, String fcontent1,
			String ftitle2, String fcontent2, String ftitle3, String fcontent3) {
		this.TPhysiques = TPhysiques;
		this.ftypeb = ftypeb;
		this.ftypebName = ftypebName;
		this.ftypem = ftypem;
		this.ftypemName = ftypemName;
		this.ftypes = ftypes;
		this.ftypesName = ftypesName;
		this.fimg = fimg;
		this.ftitle1 = ftitle1;
		this.fcontent1 = fcontent1;
		this.ftitle2 = ftitle2;
		this.fcontent2 = fcontent2;
		this.ftitle3 = ftitle3;
		this.fcontent3 = fcontent3;
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

	public String getFtypeb() {
		return this.ftypeb;
	}

	public void setFtypeb(String ftypeb) {
		this.ftypeb = ftypeb;
	}

	public String getFtypebName() {
		return this.ftypebName;
	}

	public void setFtypebName(String ftypebName) {
		this.ftypebName = ftypebName;
	}

	public String getFtypem() {
		return this.ftypem;
	}

	public void setFtypem(String ftypem) {
		this.ftypem = ftypem;
	}

	public String getFtypemName() {
		return this.ftypemName;
	}

	public void setFtypemName(String ftypemName) {
		this.ftypemName = ftypemName;
	}

	public String getFtypes() {
		return this.ftypes;
	}

	public void setFtypes(String ftypes) {
		this.ftypes = ftypes;
	}

	public String getFtypesName() {
		return this.ftypesName;
	}

	public void setFtypesName(String ftypesName) {
		this.ftypesName = ftypesName;
	}

	public String getFimg() {
		return this.fimg;
	}

	public void setFimg(String fimg) {
		this.fimg = fimg;
	}

	public String getFtitle1() {
		return this.ftitle1;
	}

	public void setFtitle1(String ftitle1) {
		this.ftitle1 = ftitle1;
	}

	public String getFcontent1() {
		return this.fcontent1;
	}

	public void setFcontent1(String fcontent1) {
		this.fcontent1 = fcontent1;
	}

	public String getFtitle2() {
		return this.ftitle2;
	}

	public void setFtitle2(String ftitle2) {
		this.ftitle2 = ftitle2;
	}

	public String getFcontent2() {
		return this.fcontent2;
	}

	public void setFcontent2(String fcontent2) {
		this.fcontent2 = fcontent2;
	}

	public String getFtitle3() {
		return this.ftitle3;
	}

	public void setFtitle3(String ftitle3) {
		this.ftitle3 = ftitle3;
	}

	public String getFcontent3() {
		return this.fcontent3;
	}

	public void setFcontent3(String fcontent3) {
		this.fcontent3 = fcontent3;
	}

}