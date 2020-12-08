package com.lhf.shardingjdbcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DicInfo {

    private Long id;
    private String dicStatus;
    private String dicValue;

    public DicInfo(String dicStatus,String dicValue){
        this.dicStatus = dicStatus;
        this.dicValue = dicValue;
    }
}
