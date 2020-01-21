package com.ricky.mapper;

import com.ricky.domain.School;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@Mapper
public interface SchoolMapper {

    School findById(Integer id);

    School findSchoolById(Integer id);

    int save(School school);
}
