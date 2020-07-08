package com.trekking.function.delegator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trekking.constant.TrekkingConstants;
import com.trekking.service.TrekkingService;
import com.trekking.service.request.TrekkingRequest;
import com.trekking.service.response.BaseResponse;
import com.trekking.utils.RequestBuilder;
import com.trekking.utils.ResponseBuilder;

@Component
public class TrekkingDelegator {

	@Autowired
	TrekkingService trekkingService;

	@Autowired
	RequestBuilder requestBuilder;

	@Autowired
	ResponseBuilder responseBuilder;

	private ObjectMapper mapper = new ObjectMapper();
	private Map<String, String> headers = new HashMap<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(TrekkingDelegator.class);

	TrekkingDelegator() {

		headers.put("Content-Type", "application/json");
		headers.put("Access-Control-Allow-Origin", "*");
	}

	public APIGatewayProxyResponseEvent delegateRequest(APIGatewayProxyRequestEvent request) {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		BaseResponse baseResponse = null;
		try {
			if (request.getPath().endsWith(TrekkingConstants.TREKKINGS_PATH)) {
				if (request.getHttpMethod() == "GET") {
					TrekkingRequest trekkingRequest = requestBuilder
							.buildTrekkingGetRequest(request.getQueryStringParameters());
					baseResponse = trekkingService.getTrekkingDetails(trekkingRequest);
					return responseBuilder.buildResponse(baseResponse, mapper, headers);
				} else if (request.getHttpMethod() == "POST") {
					TrekkingRequest trekkingRequest = requestBuilder.buildTrekkingCreateRequest(request.getBody(),
							mapper);
					baseResponse = trekkingService.createTrekkingDetail(trekkingRequest);
					return responseBuilder.buildResponse(baseResponse, mapper, headers);
				} else if (request.getHttpMethod() == "PUT") {
					TrekkingRequest trekkingRequest = requestBuilder.buildTrekkingUpdateRequest(request.getBody(),
							mapper);
					baseResponse = trekkingService.updateTrekkingDetail(trekkingRequest);
					return responseBuilder.buildResponse(baseResponse, mapper, headers);
				} else if (request.getHttpMethod() == "DELETE") {
					TrekkingRequest trekkingRequest = requestBuilder
							.buildTrekkingDeleteRequest(request.getQueryStringParameters());
					baseResponse = trekkingService.deleteTrekkingDetail(trekkingRequest);
					return responseBuilder.buildResponse(baseResponse, mapper, headers);
				}
			} else {
				LOGGER.error("Endpoint not available");
				response.setBody("Endpoint not available");
				response.setHeaders(headers);
				response.setStatusCode(404);
			}
		} catch (Exception e) {
			LOGGER.error("Exception while delegating request - {}", e.getMessage());
			response.setBody("System error");
			response.setHeaders(headers);
			response.setStatusCode(403);
		}
		return response;
	}
}
