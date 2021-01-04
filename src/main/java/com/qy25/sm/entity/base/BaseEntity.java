package com.qy25.sm.entity.base;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity<T> {
    private T id;
    private T creatorId;
    private T updateId;
    private Date addTime;
    private Date updateTime;
}
