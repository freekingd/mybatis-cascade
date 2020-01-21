package com.ricky.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@Data
@Accessors(chain = true)
public class School {
    private Integer id;
    private String name;
    private List<Student> students;
}
