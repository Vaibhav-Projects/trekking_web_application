package com.trekking.service.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponse {

	private int responseCode;
	private String responseMessage;
}
