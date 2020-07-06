package com.trekking.dao;

import java.util.List;

import com.trekking.service.request.TrekkingRequest;
import com.trekking.vo.Trekking;

public interface TrekkingDAO {

	public List<Trekking> getAllTrekkingDetails();

	public Trekking getTrekkingDetailById(String trekId);

	public int checkIfTrekkingDataExists(String trekName);

	public int createTrekkingDetail(TrekkingRequest request);

	public int updateTrekkingDetail(TrekkingRequest request);

	public int deleteTrekkingDetail(String trekId);
}
