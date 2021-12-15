package com.money.manager.dto;

import lombok.Data;

@Data
public class ClientDTO {
	private long c_number;
	private String c_id;
	private String c_password;
	private String c_email;
	private String c_photo;
	private String c_photoname;
}
