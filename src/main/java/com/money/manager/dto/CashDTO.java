package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CashDTO {
	private long s_number;
	private long c_number;
	private String s_cash;
	private String s_info;
	private String s_memo;
	private MultipartFile s_photo;
	private String s_pName;
	private long s_tAsset;
	private long s_pAsset;
	private long s_mAsset;
}
