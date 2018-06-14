package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;
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
@RequestMapping(value = "/api/v1/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/userPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询用户列表")
    public ResponseEntity<Result<PageResult<SysUser>>> userPage(@RequestBody SysUserRequest sysUserRequest) {
        return new ResponseEntity<>(Result.ok(sysUserService.querySysUserPage(sysUserRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/userList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询用户列表")
    public ResponseEntity<Result<List<SysUser>>> userList(@RequestBody SysUser sysUser) {
        return new ResponseEntity<>(Result.ok(sysUserService.querySysUserList(sysUser)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加用户")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysUserResponse>> addUser(@RequestBody SysUser sysUser) {
        return new ResponseEntity<>(Result.ok(sysUserService.addUser(sysUser)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除用户")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysUserResponse>> deleteUser(@RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysUserService.deleteUser(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改用户")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysUserResponse>> updateUser(@RequestBody SysUser sysUser) {
        return new ResponseEntity<>(Result.ok(sysUserService.updateUser(sysUser)), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取用户信息")
    @Authorization
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<Result<SysUser>> getUserDetail(@PathVariable Long id) {
        return new ResponseEntity<>(Result.ok(sysUserService.getUserDetail(id)), HttpStatus.OK);
    }

}
