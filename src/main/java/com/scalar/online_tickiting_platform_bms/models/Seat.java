package com.scalar.online_tickiting_platform_bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Seat extends BaseModel{
    private int seatNumber;
    @ManyToOne
    private SeatType seatType;

    private int rowNum;
    private int columnNum;
    @Id
    private Long id;


}
