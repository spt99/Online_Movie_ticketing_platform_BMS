package com.scalar.online_tickiting_platform_bms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class ShowSeat extends BaseModel{
    @Id
    private int ShowSeatID;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private  SeatStatus SeatStatus;

}
