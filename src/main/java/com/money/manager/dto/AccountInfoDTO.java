package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AccountInfoDTO {
	private long ai_number;
	private String a_bank;
	private String ai_info;
	private String ai_name;
	private String ai_nName;
	private String ai_memo;
	private double ai_iRate;
	private MultipartFile ai_photo;
	private String ai_pName;
	private long ai_tAsset;
	private long ai_pAsset;
	private long ai_mAsset;
}
