package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysUserRequest {

    @ApiModelProperty(value = "用户名称")
    private String userName;

}
