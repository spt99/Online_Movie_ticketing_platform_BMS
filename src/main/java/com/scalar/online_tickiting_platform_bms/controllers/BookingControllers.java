package com.scalar.online_tickiting_platform_bms.controllers;

import com.scalar.online_tickiting_platform_bms.dtos.BookMovieRequestDto;
import com.scalar.online_tickiting_platform_bms.dtos.BookMovieResponseDto;
import com.scalar.online_tickiting_platform_bms.models.Booking;
import com.scalar.online_tickiting_platform_bms.models.ResponseStatus;
import com.scalar.online_tickiting_platform_bms.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BookingControllers {
    // to call booking service method we need to create object of booking service
    //private BookingService BookingService =  new BookingService();// dependency injection principle violated
    // spring take care of all dependencies.
    // @ Controller is "setting / declaring to spring to tell that this is class we need a object later for".
    //
    private BookingService BookingService;
    // now the object for booking controller spring has created , please pass it in constructor
    @Autowired
    BookingControllers(BookingService bookingService)
    {
        this.BookingService = bookingService;
    }
    BookMovieResponseDto BookMovie(BookMovieRequestDto RequestDto){
        BookMovieResponseDto ResponseDto = new BookMovieResponseDto();
       try {
           Booking booking = BookingService.BookMovie(RequestDto.getUserID(), RequestDto.getShowId(), RequestDto.getShowSeatId());
           ResponseDto.setBookingId(booking.getId());
           ResponseDto.setStatus(ResponseStatus.SUCCESS);
           ResponseDto.setAmount(booking.getPrice());
       } catch(Exception e){
           ResponseDto.setStatus(ResponseStatus.FAILURE);
        }
       return ResponseDto;
        /*Long userid = RequestDto.getUserID();
        Long ShowId= RequestDto.getShowId();
        List<Long> showSeatId = RequestDto.getShowSeatId();*/


    }
}
