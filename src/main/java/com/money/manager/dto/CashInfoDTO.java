package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CashInfoDTO {
	private long si_number;
	private String s_cash;
	private String si_name;
	private String si_nName;
	private String si_info;
	private String si_memo;
	private String si_pName;
	private MultipartFile si_photo;
	private long si_tAsset;
	private long si_pAsset;
	private long si_mAsset;
}
