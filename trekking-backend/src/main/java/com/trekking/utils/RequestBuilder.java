package com.trekking.utils;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trekking.constant.TrekkingConstants;
import com.trekking.service.request.TrekkingRequest;
import com.trekking.vo.Trekking;

@Component
public class RequestBuilder {

	public TrekkingRequest buildTrekkingGetRequest(Map<String, String> queryParams) {
		TrekkingRequest request = new TrekkingRequest();
		Trekking trekking = new Trekking();
		if (!StringUtils.isEmpty(queryParams.get(TrekkingConstants.REQUEST_TYPE_ALL))) {
			request.setRequestType(TrekkingConstants.REQUEST_TYPE_ALL);
		}
		if (!StringUtils.isEmpty(queryParams.get(TrekkingConstants.REQUEST_TYPE_ID))) {
			trekking.setTrekId(queryParams.get("id"));
			request.setTrekking(trekking);
			request.setRequestType(TrekkingConstants.REQUEST_TYPE_ID);
		}
		return request;
	}

	public TrekkingRequest buildTrekkingCreateRequest(String body, ObjectMapper mapper) throws JsonProcessingException {
		return mapper.readValue(body, TrekkingRequest.class);
	}

	public TrekkingRequest buildTrekkingUpdateRequest(String body, ObjectMapper mapper) throws JsonProcessingException {
		return mapper.readValue(body, TrekkingRequest.class);
	}

	public TrekkingRequest buildTrekkingDeleteRequest(Map<String, String> queryParams) {
		TrekkingRequest request = new TrekkingRequest();
		Trekking trekking = new Trekking();
		if (!StringUtils.isEmpty(queryParams.get(TrekkingConstants.REQUEST_TYPE_ID))) {
			trekking.setTrekId(queryParams.get("id"));
			request.setTrekking(trekking);
			request.setRequestType(TrekkingConstants.REQUEST_TYPE_ID);
		}
		return request;
	}
}
