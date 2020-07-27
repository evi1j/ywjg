package com.hjy.system.controller;

import com.hjy.common.domin.CommonResult;
import com.hjy.common.exception.FebsException;
import com.hjy.system.entity.TSysUser;
import com.hjy.system.service.TSysUserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

/**
 * (TSysUser)表控制层
 *
 * @author liuchun
 * @since 2020-07-24 17:05:59
 */
@Slf4j
@RestController
public class TSysUserController {
    /**
     * 服务对象
     */
    @Autowired
    private TSysUserService tSysUserService;

    /**
     * 1 跳转到新增页面
     */
     @GetMapping(value = "/system/user/addPage")
     public CommonResult tSysUserAddPage() throws FebsException {
        try {
            //
            return new CommonResult(200,"success","成功!",null);
        } catch (Exception e) {
            String message = "失败";
            log.error(message, e);
            throw new FebsException(message);
        }
     }
    /**
     * 1 新增数据
     * @param tSysUser 实体对象
     * @return 新增结果
     */
    @PostMapping("/system/user/add")
    public CommonResult tSysUserAdd(@RequestBody TSysUser tSysUser) throws FebsException{
        System.err.println(tSysUser);
        try {
            //
            tSysUserService.insert(tSysUser);
            return new CommonResult(200,"success","数据添加成功!",null);
        } catch (Exception e) {
            String message = "数据添加失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    /**
     * 2 查询所有数据
     * @return 所有数据
     */
    @GetMapping("/system/user/list")
    public CommonResult tSysUserList() throws FebsException{
        try {
            //
            List<TSysUser> tSysUserList = tSysUserService.selectAll();
            System.err.println(tSysUserList);
            return new CommonResult(200,"success","查询数据成功!",tSysUserList);
        } catch (Exception e) {
            String message = "查询数据失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    /**
     * 2 通过实体查询所有数据
     * @return 所有数据
     */
    @GetMapping("/system/user/listByEntity")
    public CommonResult tSysUserListByEntity(@RequestBody TSysUser tSysUser) throws FebsException{
        try {
            //
            List<TSysUser> tSysUserList = tSysUserService.selectAllByEntity(tSysUser);
            System.err.println(tSysUserList);
            return new CommonResult(200,"success","查询数据成功!",tSysUserList);
        } catch (Exception e) {
            String message = "查询数据失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    /**
     * 3 删除数据
     * @return 删除结果
     */
    @DeleteMapping("/system/user/del")
    public CommonResult tSysUserDel(@RequestBody String parm) throws FebsException{
        JSONObject jsonObject = JSON.parseObject(parm);
        String idStr=String.valueOf(jsonObject.get("pk_id"));
        try {
            //
            tSysUserService.deleteById(idStr);
            return new CommonResult(200,"success","数据删除成功!",null);
        } catch (Exception e) {
            String message = "数据删除失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    
    /**
     * 4 通过主键查询单条数据
     * @return 单条数据
     */
    @GetMapping("/system/user/getOne")
    public CommonResult tSysUsergetOne(@RequestBody String parm) throws FebsException{
        JSONObject jsonObject = JSON.parseObject(parm);
        String idStr=String.valueOf(jsonObject.get("pk_id"));
        try {
            //
            TSysUser tSysUser = tSysUserService.selectById(idStr);
            System.err.println(tSysUser);
            return new CommonResult(200,"success","数据获取成功!",tSysUser);
        } catch (Exception e) {
            String message = "数据获取失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
    
    /**
     * 4 修改数据
     * @param tSysUser 实体对象
     * @return 修改结果
     */
    @PutMapping("/system/user/update")
    public CommonResult tSysUserUpdate(@RequestBody TSysUser tSysUser) throws FebsException{
        System.err.println(tSysUser);
        try {
            //
            tSysUserService.updateById(tSysUser);
            return new CommonResult(200,"success","修改成功!",null);
        } catch (Exception e) {
            String message = "修改失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}