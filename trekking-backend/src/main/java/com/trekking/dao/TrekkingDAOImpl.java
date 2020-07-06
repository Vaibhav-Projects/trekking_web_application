package com.trekking.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trekking.dao.mapper.TrekkingMapper;
import com.trekking.service.request.TrekkingRequest;
import com.trekking.vo.Trekking;

@Component
public class TrekkingDAOImpl implements TrekkingDAO {

	public static final Logger LOGGER = LoggerFactory.getLogger(TrekkingDAOImpl.class);

	@Autowired
	TrekkingMapper trekkingMapper;

	int result = 0;

	@Override
	public List<Trekking> getAllTrekkingDetails() {
		LOGGER.info("Getting All Trekking Details");
		List<Trekking> trekkings = new ArrayList<Trekking>();
		try {
			trekkings = trekkingMapper.getAllTrekkingDetails();
		} catch (Exception e) {
			LOGGER.error("Error while getting all trekking details - {}", e.getMessage());
		}
		return trekkings;
	}

	@Override
	public Trekking getTrekkingDetailById(String trekId) {
		LOGGER.info("Getting Trekking Detail By Id");
		Trekking trekking = new Trekking();
		try {
			trekking = trekkingMapper.getTrekkingDetailById(trekId);
		} catch (Exception e) {
			LOGGER.error("Error while getting trekking details by id - {}", e.getMessage());
		}
		return trekking;
	}

	@Override
	public int checkIfTrekkingDataExists(String trekName) {
		LOGGER.info("Checking If Trekking Data Exists");
		try {
			result = trekkingMapper.checkIfTrekkingDataExists(trekName);
		} catch (Exception e) {
			LOGGER.error("Error while checking if trekking data - {}", e.getMessage());
		}
		return result;
	}

	@Override
	public int createTrekkingDetail(TrekkingRequest request) {
		LOGGER.info("Creating Trekking Detail");
		try {
			result = trekkingMapper.createTrekkingDetail(request);
		} catch (Exception e) {
			LOGGER.error("Error while creating trekking detail - {}", e.getMessage());
		}
		return result;
	}

	@Override
	public int updateTrekkingDetail(TrekkingRequest request) {
		LOGGER.info("Updating Trekking Detail");
		try {
			result = trekkingMapper.updateTrekkingDetail(request);
		} catch (Exception e) {
			LOGGER.error("Error while updating trekking detail - {}", e.getMessage());
		}
		return result;

	}

	@Override
	public int deleteTrekkingDetail(String trekId) {
		LOGGER.info("Deleting Trekking Detail");
		try {
			result = trekkingMapper.deleteTrekkingDetail(trekId);
		} catch (Exception e) {
			LOGGER.error("Error while deleting trekking detail - {}", e.getMessage());
		}
		return result;
	}

}
