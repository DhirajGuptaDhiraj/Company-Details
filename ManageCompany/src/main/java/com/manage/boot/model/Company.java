package com.manage.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Details")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcAcc() {
		return cAcc;
	}

	public void setcAcc(String cAcc) {
		this.cAcc = cAcc;
	}

	@Column(name="corporate_name")
	private String cName;
	
	@Column(name="corporate_id")
	private String cId;
	
	@Column(name="corporate_acc")
	private String cAcc;
	
	


}
