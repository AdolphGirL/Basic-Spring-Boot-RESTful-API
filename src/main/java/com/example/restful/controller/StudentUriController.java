package com.example.restful.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restful.domain.bo.StudentV1;
import com.example.restful.domain.bo.StudentV2;
import com.example.restful.domain.bo.StudentV2Name;
import com.example.restful.response.ResponseUtils;

/**
 * api controller test
 * 
 * 測試資料
 * StudentV1
 * 	name: string
 * StudentV2
 * 	name: Name object 
 * 
 * 1. uri，進行版本控制
 * 2. 通過參數進行請求，ex: http://localhost:8080/student/param?version=1；不喜歡
 * 3. 自訂義Header
 * 4. Accept Header，ex: headers=[Accept=application/api-v1+json]
 */
@RestController
public class StudentUriController {
	
	/**
	 * uri，進行版本控制
	 */
	@GetMapping("/v1/students")
	public ResponseEntity<StudentV1> studentV1(){
		return ResponseUtils.generateResponseEntity(StudentV1.builder().name("reyes").build(), 
				HttpStatus.OK, true, "msg");
	}
	
	/**
	 * uri，進行版本控制
	 */
	@GetMapping("/v2/students")
	public ResponseEntity<StudentV2> studentV2(){
		return ResponseUtils.generateResponseEntity(StudentV2.builder().name(StudentV2Name.builder().firstName("reyes").lastName("chen").build())
				.build(), 
				HttpStatus.OK, true, "msg");
	}
	
	/**
	 * 自訂義Header版本控制
	 */
	@GetMapping(value="/students", headers = "X-API-VERSION=1")
	public ResponseEntity<StudentV1> studentV11(){
		return ResponseUtils.generateResponseEntity(StudentV1.builder().name("reyes").build(), 
				HttpStatus.OK, true, "msg");
	}
	
	/**
	 * 自訂義Header版本控制
	 */
	@GetMapping(value="/students", headers = "X-API-VERSION=2")
	public ResponseEntity<StudentV2> studentV22(){
		return ResponseUtils.generateResponseEntity(StudentV2.builder().name(StudentV2Name.builder().firstName("reyes").lastName("chen").build())
				.build(), 
				HttpStatus.OK, true, "msg");
	}
	
	/**
	 * Accept Header版本控制
	 */
	@GetMapping(value="/students", produces = "application/api-v1+json")
	public ResponseEntity<StudentV1> studentV111(){
		return ResponseUtils.generateResponseEntity(StudentV1.builder().name("reyes").build(), 
				HttpStatus.OK, true, "msg");
	}
	
	/**
	 * Accept Header版本控制
	 */
	@GetMapping(value="/students", produces = "application/api-v2+json")
	public ResponseEntity<StudentV2> studentV222(){
		return ResponseUtils.generateResponseEntity(StudentV2.builder().name(StudentV2Name.builder().firstName("reyes").lastName("chen").build())
				.build(), 
				HttpStatus.OK, true, "msg");
	}
	
}
