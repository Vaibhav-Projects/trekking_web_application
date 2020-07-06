package com.trekking.service.response;

import java.util.List;

import com.trekking.vo.Trekking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrekkingResponse extends BaseResponse {

	private List<Trekking> trekkings;

}
