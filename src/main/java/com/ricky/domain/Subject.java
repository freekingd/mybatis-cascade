package com.ricky.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author rickyzhu
 * @date 1/21/2020
 */
@Data
@Accessors(chain = true)
public class Subject {
    private Integer id;
    private String name;
    private String category;
    private Integer studentId;
}
