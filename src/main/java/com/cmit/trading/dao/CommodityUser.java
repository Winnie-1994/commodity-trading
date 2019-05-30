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
public class CommodityUser {
	
	private String userNumber;
	private String userName;
	private String userDepartment = "管理信息系统部";
	private String userPhone;
	
	public CommodityUser() {
		super();
	}
	
	public CommodityUser(String userNumber, String userName, String userDepartment, String userPhone) {
		super();
		this.userNumber = userNumber;
		this.userName = userName;
		this.userDepartment = userDepartment;
		this.userPhone = userPhone;
	}

}
