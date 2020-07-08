package com.trekking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trekking.constant.TrekkingConstants;
import com.trekking.dao.TrekkingDAO;
import com.trekking.service.request.TrekkingRequest;
import com.trekking.service.response.BaseResponse;
import com.trekking.service.response.TrekkingResponse;
import com.trekking.utils.TrekkingUtils;
import com.trekking.validator.TrekkingRequestValidator;
import com.trekking.vo.Trekking;

@Component
public class TrekkingServiceImpl implements TrekkingService {

	@Autowired
	TrekkingDAO trekkingDAO;

	@Autowired
	TrekkingUtils trekkingUtils;

	@Autowired
	TrekkingRequestValidator requestValidator;

	public TrekkingResponse getTrekkingDetails(TrekkingRequest request) {
		TrekkingResponse response = new TrekkingResponse();
		List<Trekking> trekkings = new ArrayList<Trekking>();
		requestValidator.validateRequest(request);
		if (request.getRequestType() == TrekkingConstants.REQUEST_TYPE_ALL) {
			trekkings = trekkingDAO.getAllTrekkingDetails();
			response.setTrekkings(trekkings);
		}
		if (request.getRequestType() == TrekkingConstants.REQUEST_TYPE_ID) {
			Trekking trekking = trekkingDAO.getTrekkingDetailById(request.getTrekking().getTrekId());
			trekkings.add(trekking);
			response.setTrekkings(trekkings);
		}
		trekkingUtils.populateReturnCodes(response, false, false, true);
		return response;
	}

	public BaseResponse createTrekkingDetail(TrekkingRequest request) {
		BaseResponse response = new BaseResponse();
		requestValidator.validateRequest(request);
		if (trekkingDAO.checkIfTrekkingDataExists(request.getTrekking().getTrekName()) > 0) {
			trekkingUtils.populateReturnCodes(response, true, false, false);
			return response;
		}
		int result = trekkingDAO.createTrekkingDetail(request);
		trekkingUtils.populateReturnCodes(response, false, false, result == 1);
		return response;
	}

	public BaseResponse updateTrekkingDetail(TrekkingRequest request) {
		BaseResponse response = new BaseResponse();
		requestValidator.validateRequest(request);
		int result = trekkingDAO.updateTrekkingDetail(request);
		trekkingUtils.populateReturnCodes(response, false, false, result == 1);
		return response;
	}

	public BaseResponse deleteTrekkingDetail(TrekkingRequest request) {
		BaseResponse response = new BaseResponse();
		int result = trekkingDAO.deleteTrekkingDetail(request.getTrekking().getTrekId());
		trekkingUtils.populateReturnCodes(response, false, false, result == 1);
		return response;
	}
}
