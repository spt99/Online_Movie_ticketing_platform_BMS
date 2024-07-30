package com.scalar.online_tickiting_platform_bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter@Getter
@Entity

public class Payment extends BaseModel{
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod PayMethod;

    private int ReferenceNum;
    private Date timestamp;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus PaymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider PaymentProvider;
    @Id
    private Long id;

    // ORM : Object Relation Mapping
    // convert all models into tables
    // write corresponding sql queries
    // we will call ORM function and ORM will create the queries behind the scene

}
