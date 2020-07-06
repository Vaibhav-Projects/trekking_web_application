package com.trekking.dao.mapper.util;

import org.apache.ibatis.jdbc.SQL;

import com.trekking.service.request.TrekkingRequest;

public class TrekkingDynamicQuery {

	public String getAllTrekkingDetails() {
		return new SQL() {
			{
				SELECT("trek_id as trekId,trek_name as trekName,trek_desc as TrekDesc,"
						+ "trek_price as trekPrice,trek_start_time as trekStartTime,trek_end_time as trekEndTime");
				FROM("TREKKING_DETAILS");
				ORDER_BY("trek_id ASC");
			}
		}.toString();
	}

	public String getTrekkingDetailById(String id) {
		return new SQL() {
			{
				SELECT("trek_id as trekId,trek_name as trekName,trek_desc as TrekDesc,"
						+ "trek_price as trekPrice,trek_start_time as trekStartTime,trek_end_time as trekEndTime");
				FROM("TREKKING_DETAILS");
				WHERE("trek_id=#{trekId}");
				ORDER_BY("trek_id ASC");
			}
		}.toString();
	}

	public String checkIfTrekkingDataExists(String trekName) {
		return new SQL() {
			{
				SELECT("COUNT(*)");
				FROM("TREKKING_DETAILS");
				WHERE("trek_name=#{trekName}");
			}
		}.toString();
	}

	public String createTrekkingDetail(TrekkingRequest request) {
		return new SQL() {
			{
				INSERT_INTO("TREKKING_DETAILS");
				INTO_COLUMNS("trek_name,trek_desc,trek_price,trek_start_time,trek_end_time");
				INTO_VALUES("#{trekking.trekName},#{trekking.trekDesc},#{trekking.trekPrice},"
						+ "#{trekking.trekStartTime},#{trekking.trekEndTime}");
			}
		}.toString();
	}

	public String updateTrekkingDetail(TrekkingRequest request) {
		return new SQL() {
			{
				UPDATE("TREKKING_DETAILS");
				SET("trek_name=#{trekking.trekName},trek_desc=#{trekking.trekDesc},trek_price=#{trekking.trekPrice},"
						+ "trek_start_time=#{trekking.trekStartTime},trek_end_time=#{trekking.trekEndTime}");
				WHERE("trek_id=#{trekking.trekId}");
			}
		}.toString();
	}

	public String deleteTrekkingDetail(String trekId) {
		return new SQL() {
			{
				DELETE_FROM("TREKKING_DETAILS");
				WHERE("trek_id=#{trekId}");
			}
		}.toString();
	}

}
