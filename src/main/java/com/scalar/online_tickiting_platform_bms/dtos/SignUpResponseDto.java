package com.scalar.online_tickiting_platform_bms.dtos;

import com.scalar.online_tickiting_platform_bms.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SignUpResponseDto {
    private ResponseStatus status;
    private Long UserId;
}
