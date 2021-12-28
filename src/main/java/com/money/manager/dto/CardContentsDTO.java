package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CardContentsDTO {

	private long dc_number;
	private long di_number;
	private String di_name; // 카드 이름
	private String dc_info;
	private String dc_name;
	private String dc_useCon; // 사용 내역
	private String di_useAcc; // 사용 계좌
	private String dc_nName;
	private String dc_memo;
	private double dc_iRate;
	private MultipartFile dc_photo;
	private String dc_pName;
	private long dc_tAsset;
	private long dc_pAsset;
	private long dc_mAsset;
}
