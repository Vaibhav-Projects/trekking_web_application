package com.trekking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trekking.delegator.TrekkingDelegator;
import com.trekking.service.request.TrekkingRequest;
import com.trekking.service.response.BaseResponse;
import com.trekking.service.response.TrekkingResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/trekkings", produces = "application/json", consumes = "application/json")
public class TrekkingServiceImpl implements TrekkingService {

	@Autowired
	TrekkingDelegator trekkingDelegator;

	@Override
	@GetMapping
	public TrekkingResponse getTrekkingDetails(@RequestParam(required = false) boolean all,
			@RequestParam(required = false) String id) {
		return trekkingDelegator.getTrekkingDetails(all, id);
	}

	@Override
	@PostMapping
	public BaseResponse createTrekkingDetail(@RequestBody TrekkingRequest request) {
		return trekkingDelegator.createTrekkingDetail(request);
	}

	@Override
	@PutMapping
	public BaseResponse updateTrekkingDetail(@RequestBody TrekkingRequest request) {
		return trekkingDelegator.updateTrekkingDetail(request);

	}

	@Override
	@DeleteMapping
	public BaseResponse deleteTrekkingDetail(@RequestParam String id) {
		return trekkingDelegator.deleteTrekkingDetail(id);
	}
}
