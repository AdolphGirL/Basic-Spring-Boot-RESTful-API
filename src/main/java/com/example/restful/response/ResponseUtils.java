package com.example.restful.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
	
	/**
	 * 產生請求結果響應對象
	 * @param <T>		封裝數據泛型
	 * @param data		封裝的數據
	 * @param status	狀態碼
	 * @param success	成功與否
	 * @param message	結果信息
	 * @return
	 */
	public static <T> ResponseEntity<T> generateResponseEntity(T data, HttpStatus status, Boolean success, String message){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("success", success.toString());
		headers.add("message", message);
		
		return new ResponseEntity<T>(data, headers, status);
	}
}
