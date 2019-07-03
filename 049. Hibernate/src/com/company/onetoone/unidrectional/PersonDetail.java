package com.company.onetoone.unidrectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonDetail")
public class PersonDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "hobby")
	private String hobby;

	public PersonDetail() {
	}

	public PersonDetail(String address, String hobby) {
		super();
		this.address = address;
		this.hobby = hobby;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "PersonDetail [id=" + id + ", address=" + address + ", hobby=" + hobby + "]";
	}
}