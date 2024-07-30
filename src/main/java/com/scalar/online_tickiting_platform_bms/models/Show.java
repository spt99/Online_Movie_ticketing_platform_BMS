package com.scalar.online_tickiting_platform_bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter@Getter
@Entity (name ="shows")
public class Show extends BaseModel{
    private String title;
    @ManyToOne
    private Movie movie;
    private Date StartTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    @Id
    private Long id;


}
