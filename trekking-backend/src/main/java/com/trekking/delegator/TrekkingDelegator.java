package com.trekking.delegator;

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
public class TrekkingDelegator {

	@Autowired
	TrekkingDAO trekkingDAO;

	@Autowired
	TrekkingUtils trekkingUtils;

	@Autowired
	TrekkingRequestValidator requestValidator;

	// need to work on response object

	public TrekkingResponse getTrekkingDetails(boolean all, String id) {
		TrekkingResponse response = new TrekkingResponse();
		TrekkingRequest request = trekkingUtils.createTrekkingRequest(all, id);
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

	public BaseResponse deleteTrekkingDetail(String id) {
		BaseResponse response = new BaseResponse();
		int result = trekkingDAO.deleteTrekkingDetail(id);
		trekkingUtils.populateReturnCodes(response, false, false, result == 1);
		return response;
	}
}
