package com.scalar.online_tickiting_platform_bms.dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter@Setter

public class BookMovieRequestDto {

    private Long userID;
    private Long ShowId;
    private List<Long> showSeatId;

}
