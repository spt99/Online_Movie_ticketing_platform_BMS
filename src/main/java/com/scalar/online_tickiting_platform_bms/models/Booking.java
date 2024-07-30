package com.scalar.online_tickiting_platform_bms.models;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @Id
    private int booking_id;
    @ManyToMany
    private List<ShowSeat> seats;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus Bookingstatus;
    @ManyToOne
    private User user;

    private int Price;
    private Date TimeOfBooking;



}
