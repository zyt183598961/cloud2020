package com.zyt.cloud.provider.service;

import com.zyt.cloud.provider.dao.SignDao;
import com.zyt.common.dto.SignDto;
import com.zyt.common.vo.R;
import org.springframework.web.bind.annotation.RequestParam;

public interface ISignService {

    R save(SignDto signDto);

    R getAll();

    R getByName(String name);
}
