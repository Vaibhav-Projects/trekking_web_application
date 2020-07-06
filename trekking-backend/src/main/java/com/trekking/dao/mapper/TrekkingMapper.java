package com.trekking.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.trekking.dao.mapper.util.TrekkingDynamicQuery;
import com.trekking.service.request.TrekkingRequest;
import com.trekking.vo.Trekking;

@Mapper
public interface TrekkingMapper {

	@SelectProvider(type = TrekkingDynamicQuery.class, method = "getAllTrekkingDetails")
	public List<Trekking> getAllTrekkingDetails();

	@SelectProvider(type = TrekkingDynamicQuery.class, method = "getTrekkingDetailById")
	public Trekking getTrekkingDetailById(String trekId);

	@SelectProvider(type = TrekkingDynamicQuery.class, method = "checkIfTrekkingDataExists")
	public int checkIfTrekkingDataExists(String trekName);

	@InsertProvider(type = TrekkingDynamicQuery.class, method = "createTrekkingDetail")
	public int createTrekkingDetail(TrekkingRequest request);

	@UpdateProvider(type = TrekkingDynamicQuery.class, method = "updateTrekkingDetail")
	public int updateTrekkingDetail(TrekkingRequest request);

	@DeleteProvider(type = TrekkingDynamicQuery.class, method = "deleteTrekkingDetail")
	public int deleteTrekkingDetail(String trekId);
}
