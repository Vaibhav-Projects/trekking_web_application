package com.trekking.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trekking.constant.TrekkingConstants;
import com.trekking.service.response.BaseResponse;

@Component
public class ResponseBuilder {

	public APIGatewayProxyResponseEvent buildResponse(BaseResponse baseResponse, ObjectMapper mapper,
			Map<String, String> headers) throws JsonProcessingException {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		String responseCodeMessage = baseResponse.getResponseMessage();
		if (responseCodeMessage == TrekkingConstants.RESPONSE_CODE_SUCCESS_MESSAGE) {
			return build(TrekkingConstants.RESPONSE_CODE_SUCCESS, buildBody(baseResponse, mapper), headers);
		} else if (responseCodeMessage == TrekkingConstants.RESPONSE_CODE_ALREADY_EXISTS_MESSAGE) {
			return build(TrekkingConstants.RESPONSE_CODE_ALREADY_EXISTS, buildBody(baseResponse, mapper), headers);
		} else if (responseCodeMessage == TrekkingConstants.RESPONSE_CODE_NOT_FOUND_MESSAGE) {
			return build(TrekkingConstants.RESPONSE_CODE_NOT_FOUND, buildBody(baseResponse, mapper), headers);
		}
		return response;
	}

	public String buildBody(Object object, ObjectMapper mapper) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}

	private APIGatewayProxyResponseEvent build(int statusCode, String body, Map<String, String> headers) {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		response.setStatusCode(statusCode);
		response.setHeaders(headers);
		response.setBody(body);
		return response;
	}

}
