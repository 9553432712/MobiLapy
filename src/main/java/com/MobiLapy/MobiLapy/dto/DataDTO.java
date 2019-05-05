package com.MobiLapy.MobiLapy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class DataDTO {
	private String name;
	private String email;
	private String phone;
	private String device;
	private String Brand_model;
	private String Issue;



}
