package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CardDTO {
	private long d_number;
	private long c_number;
	private String d_cCompany;
	private String d_info;
	private String d_memo;
	private MultipartFile d_photo;
	private String d_pName;
	private long d_tAsset;
	private long d_pAsset;
	private long d_mAsset;
}
