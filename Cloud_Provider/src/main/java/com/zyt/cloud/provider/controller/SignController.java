package com.zyt.cloud.provider.controller;

import com.zyt.cloud.provider.service.ISignService;
import com.zyt.common.dto.SignDTO;
import com.zyt.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignController {

    @Autowired
    private ISignService signService;


    @PostMapping("/save")
    public R save(@RequestBody SignDTO signDto) {
        return signService.save(signDto);
    }


    @GetMapping("/getAll")
    public R getAll() {
        return signService.getAll();
    }

    @GetMapping("/getByName")
    R getByName(@RequestParam String name){
        return signService.getByName(name);
    }

}
