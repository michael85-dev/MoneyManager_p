package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CardInfoDTO {
	private long di_number;
	private String d_cCompany;
	private String di_name;
	private String di_nName;
	private String di_info;
	private String di_memo;
	private String di_pName;
	private MultipartFile di_photo;
	private long di_tAsset;
	private long di_pAsset;
	private long di_mAsset;
}
