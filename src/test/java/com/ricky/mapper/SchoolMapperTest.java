package com.ricky.mapper;

import com.ricky.domain.School;
import com.ricky.domain.Student;
import com.ricky.domain.Subject;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@MybatisTest
class SchoolMapperTest {

    @Resource
    private SchoolMapper schoolMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private SubjectMapper subjectMapper;

    @Test
    public void save() {
        School originSchool = buildSchool();
        saveSchoolDetail(originSchool);
        School school = schoolMapper.findById(1);
        School school_1 = schoolMapper.findSchoolById(1);
        assertThat(school, equalTo(school_1));
        assertThat(school.getName(), equalTo(originSchool.getName()));
        assertThat(school.getStudents().size(), equalTo(originSchool.getStudents().size()));
        assertThat(school.getStudents().get(0).getId(), notNullValue());
        assertThat(school.getStudents().get(0).getSchoolId(), notNullValue());
        assertThat(school.getStudents().get(0).getName(),
                equalTo(originSchool.getStudents().get(0).getName()));
        assertThat(school.getStudents().get(0).getSubjects().get(0).getCategory(),
                equalTo(originSchool.getStudents().get(0).getSubjects().get(0).getCategory()));
        assertThat(school.getStudents().get(1).getSubjects().get(1).getCategory(),
                equalTo(originSchool.getStudents().get(1).getSubjects().get(1).getCategory()));
    }

    @SuppressWarnings("Duplicates")
    private int saveSchoolDetail(School school) {
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

    private School buildSchool() {
        List<Subject> subjects_1 = Arrays.asList(
                new Subject()
                        .setName("subject-1")
                        .setCategory("category_1"),
                new Subject()
                        .setName("subject-2")
                        .setCategory("category_2")
        );
        List<Subject> subjects_2 = Arrays.asList(
                new Subject()
                        .setName("subject-3")
                        .setCategory("category_3"),
                new Subject()
                        .setName("subject-4")
                        .setCategory("category_4")
        );
        return new School()
                .setName("school_1")
                .setStudents(Arrays.asList(
                        new Student()
                                .setName("student_1")
                                .setSubjects(subjects_1),
                        new Student()
                                .setName("student_2")
                                .setSubjects(subjects_2)
                ));
    }
}