package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysQuestionnaire;
import com.xdht.disease.sys.service.SysQuestionnaireService;
import com.xdht.disease.sys.vo.request.SysQuestionnaireRequest;
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
@RequestMapping(value = "/api/v1/sysQuestionnaire")
public class SysQuestionnaireController {

    @Autowired
    private SysQuestionnaireService sysQuestionnaireService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<SysQuestionnaire>>> recordList(@RequestBody SysQuestionnaireRequest sysQuestionnaireRequest) {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.queryList(sysQuestionnaireRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/listAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<SysQuestionnaire>>> listAll() {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.queryListAll()), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<SysQuestionnaire>>> recordPage(@RequestBody SysQuestionnaireRequest sysQuestionnaireRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.queryListPage(sysQuestionnaireRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<SysQuestionnaire>> add(@RequestBody SysQuestionnaire sysQuestionnaire) {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.add(sysQuestionnaire)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<SysQuestionnaire>> delete(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<SysQuestionnaire>> update(@RequestBody SysQuestionnaire sysQuestionnaire) {
        return new ResponseEntity<>(Result.ok(sysQuestionnaireService.update(sysQuestionnaire)), HttpStatus.OK);
    }



}
