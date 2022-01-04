package com.zyt.cloud.provider.service.impl;

import com.zyt.cloud.provider.dao.SignDao;
import com.zyt.cloud.provider.service.ISignService;
import com.zyt.common.dto.SignDto;
import com.zyt.common.entity.StudentSign;
import com.zyt.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.resources.FormatData;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SignServiceImpl implements ISignService {

    @Autowired
    private SignDao signDao;

    @Override
    public R save(SignDto signDto) {
        StudentSign studentSign = new StudentSign();
        studentSign.setName(signDto.getName());
        studentSign.setClsname(signDto.getClaname());
        studentSign.setType("课前签到");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        studentSign.setStime(time);
        int i = signDao.save(studentSign);
        if (i > 0){
            return R.ok();
        }else {
            return R.fail();
        }

    }

    @Override
    public R getAll() {
        return R.ok(signDao.getAll());
    }

    @Override
    public R getByName(String name) {
        return R.ok(signDao.getByName(name));
    }
}
