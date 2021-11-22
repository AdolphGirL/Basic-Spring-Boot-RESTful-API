package com.example.restful.domain.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentV2Name {
	
	private String firstName;
	private String lastName;
	
}
