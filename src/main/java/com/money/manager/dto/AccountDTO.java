package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AccountDTO {
	private long a_number;
	private long c_number;
	private String a_bank;
	private String a_info;
	private String a_memo;
	private MultipartFile a_photo;
	private String a_pName;
	private long a_tAsset;
	private long a_pAsset;
	private long a_mAsset;
}
