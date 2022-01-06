package com.zyt.consumer.fallback;

import com.zyt.common.dto.SignDTO;
import com.zyt.common.vo.R;
import com.zyt.consumer.servie.SignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component  //IOC创建
public class SignFallBack implements FallbackFactory<SignService> {

    @Override
    public SignService create(Throwable throwable) {
        return new SignService(){
            @Override
            public R save(SignDTO signDto) {
                return R.fail("save方法降级");
            }
            @Override
            public R getAll() {
                return R.fail("getAll方法降级");
            }
            @Override
            public R getByName(String name) {
                return R.fail("getByName方法降级");
            }
        };

    }
}
