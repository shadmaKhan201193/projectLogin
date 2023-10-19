package com.itl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OtpMst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "otpsucces")
	private String otpsucces="";

	@Column(name = "otpsucces2")
	private String otpsucces2="";


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOtpsucces() {
		return otpsucces;
	}

	public void setOtpsucces(String otpsucces) {
		this.otpsucces = otpsucces;
	}

	public String getOtpsucces2() {
		return otpsucces2;
	}

	public void setOtpsucces2(String otpsucces2) {
		this.otpsucces2 = otpsucces2;
	}

	
		}
