package com.trekking.utils;

import org.springframework.stereotype.Component;

import com.trekking.constant.TrekkingConstants;
import com.trekking.service.response.BaseResponse;

@Component
public class TrekkingUtils {

	public void populateReturnCodes(BaseResponse response, boolean isExists, boolean noData, boolean success) {
		if (isExists) {
			response.setResponseCode(TrekkingConstants.RESPONSE_CODE_ALREADY_EXISTS);
			response.setResponseMessage(TrekkingConstants.RESPONSE_CODE_ALREADY_EXISTS_MESSAGE);
		}
		if (noData) {
			response.setResponseCode(TrekkingConstants.RESPONSE_CODE_NOT_FOUND);
			response.setResponseMessage(TrekkingConstants.RESPONSE_CODE_NOT_FOUND_MESSAGE);
		}
		if (success) {
			response.setResponseCode(TrekkingConstants.RESPONSE_CODE_SUCCESS);
			response.setResponseMessage(TrekkingConstants.RESPONSE_CODE_SUCCESS_MESSAGE);
		}
	}
}
