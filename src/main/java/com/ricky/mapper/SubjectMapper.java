package com.ricky.mapper;

import com.ricky.domain.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@Mapper
public interface SubjectMapper {
    int saveBatch(@Param("subjects") List<Subject> subjects, @Param("studentId") Integer studentId);
}
