package com.zyt.cloud.provider.dao;

import com.zyt.common.entity.StudentSign;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SignDao {

    int save(StudentSign studentSign);

    List<StudentSign> getAll();

    List<StudentSign> getByName(String name);

}
