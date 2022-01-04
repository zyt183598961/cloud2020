package com.zyt.consumer.controller;

import com.zyt.common.dto.SignDto;
import com.zyt.common.vo.R;
import com.zyt.consumer.servie.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignController {

    @Autowired
    private SignService signService;

    //添加
    @PostMapping("/save")
    public R save(@RequestBody SignDto signDto){
        return signService.save(signDto);
    }

    @GetMapping("/getALL")
    public R get() {
        return signService.getAll();
    }


    @GetMapping("/getByName")
    R getByName(@RequestParam String name){
        return signService.getByName(name);
    }
}
