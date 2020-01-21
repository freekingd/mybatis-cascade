package com.ricky.service;

import com.ricky.domain.School;
import com.ricky.domain.Student;
import com.ricky.mapper.SchoolMapper;
import com.ricky.mapper.StudentMapper;
import com.ricky.mapper.SubjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@Service
public class SchoolService {
    @Resource
    private SchoolMapper schoolMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private SubjectMapper subjectMapper;

    public School findById(Integer id) {
        return schoolMapper.findById(id);
    }

    public int save(School school) {
        schoolMapper.save(school);
        if (school.getStudents() != null) {
            for (Student student : school.getStudents()) {
                student.setSchoolId(school.getId());
                studentMapper.save(student);
                if (!CollectionUtils.isEmpty(student.getSubjects())) {
                    subjectMapper.saveBatch(student.getSubjects(), student.getId());
                }
            }
        }
        return school.getId();
    }
}
