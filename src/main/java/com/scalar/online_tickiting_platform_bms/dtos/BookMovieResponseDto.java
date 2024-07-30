package com.scalar.online_tickiting_platform_bms.dtos;

import com.scalar.online_tickiting_platform_bms.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BookMovieResponseDto {
    private int amount;
    private Long bookingId;
    private ResponseStatus status;
}
