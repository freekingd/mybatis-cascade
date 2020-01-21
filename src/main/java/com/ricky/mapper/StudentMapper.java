package com.ricky.mapper;

import com.ricky.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@Mapper
public interface StudentMapper {
    int save(Student student);
}
