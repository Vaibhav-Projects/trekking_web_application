package com.trekking.service;

import com.trekking.service.request.TrekkingRequest;
import com.trekking.service.response.BaseResponse;
import com.trekking.service.response.TrekkingResponse;

public interface TrekkingService {

	public TrekkingResponse getTrekkingDetails(TrekkingRequest request);

	public BaseResponse createTrekkingDetail(TrekkingRequest request);

	public BaseResponse updateTrekkingDetail(TrekkingRequest request);

	public BaseResponse deleteTrekkingDetail(TrekkingRequest request);
}
