package com.zyt.consumer.controller;

import com.zyt.common.dto.SignDTO;
import com.zyt.common.vo.R;
import com.zyt.consumer.servie.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "签到目录")
public class SignController {

    @Autowired
    private SignService signService;

    //添加
    @ApiOperation(value = "签到", notes = "签到")
    @PostMapping("/save")
    public R save(@RequestBody SignDTO signDto){
        return signService.save(signDto);
    }

    @GetMapping("/getALL")
    @ApiOperation(value = "查询所有签到", notes = "查询所有签到")
    public R get() {
        return signService.getAll();
    }


    @GetMapping("/getByName")
    @ApiOperation(value = "查看指定学生签到记录", notes = "查看指定学生签到记录")
    R getByName(@RequestParam String name){
        return signService.getByName(name);
    }
}
