package com.zyt.cloud.provider.service;

import com.zyt.cloud.provider.dao.SignDao;
import com.zyt.common.dto.SignDTO;
import com.zyt.common.vo.R;
import org.springframework.web.bind.annotation.RequestParam;

public interface ISignService {

    R save(SignDTO signDto);

    R getAll();

    R getByName(String name);
}
