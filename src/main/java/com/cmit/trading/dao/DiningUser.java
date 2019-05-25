package com.cmit.trading.dao;

import lombok.Getter;
import lombok.Setter;

/**
* @author: wunt
* @date: 2019-04-13 
* @description:
*/
@Getter
@Setter
public class DiningUser{
	
	private String number;
	private String name;
	private String department = "管理信息系统部";
	private String phone;
	
	public DiningUser() {
		super();
	}
	
	public DiningUser(String number, String name, String department, String phone) {
		super();
		this.number = number;
		this.name = name;
		this.department = department;
		this.phone = phone;
	}

}
