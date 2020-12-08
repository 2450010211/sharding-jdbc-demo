package com.lhf.shardingjdbcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    private Long id;
    private Long userId;
    private String courseName;
    private String courseStatus;
    private Date buildTime;

   public Course(Long userId,String courseName,String courseStatus,Date buildTime){
        this.userId = userId;
        this.courseName = courseName;
        this.courseStatus = courseStatus;
        this.buildTime = buildTime;
    }

}
