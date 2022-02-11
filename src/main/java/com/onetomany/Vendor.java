package com.onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor {
	
	@Id
	@Column(name="vid")
	private int vendorId;
	
	@Column(name="vname")
	private String vendorName;
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity = Customers.class,cascade = CascadeType.ALL)
	@JoinColumn(name="fkvid")
	private Set obj;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Set getObj() {
		return obj;
	}

	public void setObj(Set obj) {
		this.obj = obj;
	}
	
}
