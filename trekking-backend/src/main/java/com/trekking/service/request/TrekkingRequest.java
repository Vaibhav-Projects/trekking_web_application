package com.trekking.service.request;

import com.trekking.vo.Trekking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString	
public class TrekkingRequest {

	private Trekking trekking;
	private String requestType;
}