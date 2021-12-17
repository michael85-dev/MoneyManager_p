package com.money.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ClientDTO {
	private long c_number;  // 회원 분류를 위한 번호 설정 (자동기입)
	private String c_id; // 로그인을 위한 ID
	private String c_password; // 로그인을 위한 비밀번
	private String c_name; // 회원 이
	private String c_nickname; // 사용 닉네
	private String c_email; // 비밀번호 분실시 사용할 확인용 이메일 
	private MultipartFile c_photo; // 사진? 
	private String c_pName; // 사진?
}
