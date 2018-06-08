package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentService;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentRequest;
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
@RequestMapping(value = "/api/v1/recordIndividualProtectiveEquipment")
public class RecordIndividualProtectiveEquipmentController {

    @Autowired
    private RecordIndividualProtectiveEquipmentService recordService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordIndividualProtectiveEquipment>>> recordList(@CurrentUser User user, @RequestBody RecordIndividualProtectiveEquipmentRequest recordRequest) {
        return new ResponseEntity<>(Result.ok(recordService.queryList(recordRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordIndividualProtectiveEquipment>>> recordPage(@CurrentUser User user, @RequestBody RecordIndividualProtectiveEquipmentRequest recordRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordService.queryListPage(recordRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordIndividualProtectiveEquipment>> add(@CurrentUser User user, @RequestBody RecordIndividualProtectiveEquipment record) {
        return new ResponseEntity<>(Result.ok(recordService.add(record)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordIndividualProtectiveEquipment>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordIndividualProtectiveEquipment>> update(@CurrentUser User user, @RequestBody RecordIndividualProtectiveEquipment record) {
        return new ResponseEntity<>(Result.ok(recordService.update(record)), HttpStatus.OK);
    }



}