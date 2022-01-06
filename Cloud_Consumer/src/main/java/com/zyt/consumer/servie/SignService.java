package com.zyt.consumer.servie;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zyt.common.dto.SignDTO;
import com.zyt.common.vo.R;
import com.zyt.consumer.fallback.SignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "xph-provider", fallbackFactory = SignFallBack.class)
public interface SignService {

    //签到
    @PostMapping("/save")
    R save(@RequestBody SignDTO signDto);

    //方法要合provider里的一样
    @GetMapping("/getAll")
    R getAll();

    @GetMapping("/getByName")
    R getByName(@RequestParam String name);

}
