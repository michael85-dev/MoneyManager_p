package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AccountContentsDTO { //계좌 내역 입력 하는 
	private long ac_number;
	private long ai_number;
	private String a_bank;
	private String ac_info;
	private String ac_name;
	private String ac_useCon; // 사용 내역
	private String ai_useAcc; // 사용 계좌
	private String ac_nName;
	private String ac_memo;
	private double ac_iRate;
	private MultipartFile ac_photo;
	private String ac_pName;
	private long ac_tAsset;
	private long ac_pAsset;
	private long ac_mAsset;
}
