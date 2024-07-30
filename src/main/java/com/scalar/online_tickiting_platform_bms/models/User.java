package com.scalar.online_tickiting_platform_bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class User extends BaseModel{
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Booking> booking;
}
