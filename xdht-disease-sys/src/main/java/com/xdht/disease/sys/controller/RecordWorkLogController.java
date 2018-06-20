package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.sys.service.RecordWorkLogService;
import com.xdht.disease.sys.vo.request.RecordWorkLogInputRequest;
import com.xdht.disease.sys.vo.request.RecordWorkLogRequest;
import com.xdht.disease.sys.vo.response.RecordWorkLogDetailResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/recordWorkLog")
public class RecordWorkLogController {

    @Autowired
    private RecordWorkLogService recordWorkLogService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordWorkLog>>> recordList(@RequestBody RecordWorkLogRequest recordWorkLogRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.queryList(recordWorkLogRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/pageList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordWorkLog>>> recordPage(@RequestBody RecordWorkLogRequest recordWorkLogRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.queryListPage(recordWorkLogRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordWorkLog>> add(@RequestBody RecordWorkLogInputRequest recordWorkLogInputRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.add(recordWorkLogInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordWorkLog>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<RecordWorkLog>> update(@RequestBody RecordWorkLogInputRequest recordWorkLogInputRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.update(recordWorkLogInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取 --详细内容")
    public ResponseEntity<Result<RecordWorkLogDetailResponse>> getRecordWorkLogDetail(@PathVariable Long id) {
        RecordWorkLogDetailResponse recordWorkLogDetailResponse = this.recordWorkLogService.queryWorkLogDetail(id);
        return new ResponseEntity<>(Result.ok(recordWorkLogDetailResponse), HttpStatus.OK);
    }


}
