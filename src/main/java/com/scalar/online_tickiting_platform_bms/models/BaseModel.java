package com.scalar.online_tickiting_platform_bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Setter
@Getter
//@MappedSuperclass
public class BaseModel {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // nothing but first row will have id as 1 , and row 2 has id 2
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    //getter and setter method of all classes is provided by lombok



}
