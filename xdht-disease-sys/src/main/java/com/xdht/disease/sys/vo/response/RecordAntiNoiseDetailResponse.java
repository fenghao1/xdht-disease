package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.model.RecordHazardFactors;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordAntiNoiseDetailResponse {

    @ApiModelProperty(value = "防噪声设施调查表")
    private Map<String, Object> recordAntiNoiseFacilities;

    @ApiModelProperty(value = "防噪声设施调查表--调查内容")
    private List<Map<String, Object>> recordAntiNoiseFacilitiesDataList;



}
