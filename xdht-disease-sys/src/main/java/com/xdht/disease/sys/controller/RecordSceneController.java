
package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.sys.service.RecordSceneService;
import com.xdht.disease.sys.vo.request.RecordScenQuestionnaireRequest;
import com.xdht.disease.sys.vo.request.RecordSceneInputRequest;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
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
@RequestMapping(value = "/api/v1/recordScene")
public class RecordSceneController {

    @Autowired
    private RecordSceneService recordSceneService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordScene>>> recordList(@RequestBody RecordSceneRequest recordSceneRequest) {
        return new ResponseEntity<>(Result.ok(recordSceneService.queryList(recordSceneRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordScene>>> recordPage(@RequestBody RecordSceneRequest recordSceneRequest) {
        return new ResponseEntity<>(Result.ok(recordSceneService.queryListPage(recordSceneRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordScene>> addRecordScene(@RequestBody RecordScene recordScene) {
        return new ResponseEntity<>(Result.ok(recordSceneService.addRecordScene(recordScene)), HttpStatus.OK);
    }
    @RequestMapping(value = "/addAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordScene>> addAll(@RequestBody RecordSceneInputRequest recordSceneInputRequest) {

        return new ResponseEntity<>(Result.ok(recordSceneService.addAll(recordSceneInputRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordScene>> deleteRecordScene(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordSceneService.deleteRecordScene(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordScene>> updateRecordScene(@RequestBody RecordScene recordScene) {
        return new ResponseEntity<>(Result.ok(recordSceneService.updateRecordScene(recordScene)), HttpStatus.OK);
    }



}
