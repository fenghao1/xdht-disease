package com.xdht.disease.sys.vo.response;

import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by L on 2018/6/14.
 */
@Data
public class RecordIndividualProtectiveDetailResponse {

    @ApiModelProperty(value = "个体防护用品调查表")
    private Map<String, Object> recordIndividualProtective;

    @ApiModelProperty(value = "个体防护用品调查表--调查内容")
    private List<Map<String, Object>> recordIndividualProtectiveDataList;



}
