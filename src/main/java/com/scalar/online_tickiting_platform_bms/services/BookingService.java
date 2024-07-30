package com.scalar.online_tickiting_platform_bms.services;

import com.scalar.online_tickiting_platform_bms.Exceptions.InvalidShowException;
import com.scalar.online_tickiting_platform_bms.Exceptions.InvalidUserException;
import com.scalar.online_tickiting_platform_bms.Exceptions.ShowSeatNotAvailableException;
import com.scalar.online_tickiting_platform_bms.Repositories.ShowRepository;
import com.scalar.online_tickiting_platform_bms.Repositories.ShowSeatRepository;
import com.scalar.online_tickiting_platform_bms.Repositories.UserRepository;
import com.scalar.online_tickiting_platform_bms.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculator;

    @Autowired
    BookingService(UserRepository userRepository, ShowRepository showRepository,ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculator) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculator = new PriceCalculatorService();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking BookMovie(Long userId, Long showId, List<Long> ShowSeatId) throws InvalidUserException, InvalidShowException, ShowSeatNotAvailableException {
        // actual business logic comes here
        // ---- Take a Lock here (Approach 1)
        // here doing Approach 1 as approach 2 method involve doing transaction in between code which is difficult ,
        // doing approach 2 in spring boot is tricky.
        //get all objects from database from userid/id.
        // got user object, show object, show seat object
        //--- take a lock---(Approach 2)
        // check if seats available or nor,
        // if no throw exception
        // if yes, mark status of seat as blocked.
        //save in database
        //----- unlock----- (Approach 2)
        // we will use spring boot to take a lock
        // payment thing will happen here
        // create booking status as pending status
        // return booking object
        // --------Release the lock (Approach 1)
        // if using optional , we make code null pointer exception checked
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new InvalidUserException("Invalid User, Enter valid User");
        }
        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()) {
            throw new InvalidShowException("Invalid Show, Enter valid Show");
        }
        Show show = optionalShow.get();
        List<ShowSeat> ShowSeat = showSeatRepository.findAll();

        // Check seats available or not.
        for(ShowSeat showSeat: ShowSeat){
            if(!showSeat.getSeatStatus().equals(SeatStatus.Available))
            {
                throw new ShowSeatNotAvailableException("No Show Seat available");
            }
        }
        List<ShowSeat> FinalShowSeats = new ArrayList<>();
        // mark available seat as blocked
        for(ShowSeat showSeat: ShowSeat){
            showSeat.setSeatStatus(SeatStatus.Blocked);
            showSeatRepository.save(showSeat);
            FinalShowSeats.add(showSeatRepository.save(showSeat));
        }
        Booking booking = new Booking();
        booking.setBookingstatus(BookingStatus.PENDING);
        booking.setTimeOfBooking(new Date());
        booking.setShow(show);
        booking.setUser(user);
        booking.setSeats(FinalShowSeats);
        booking.setPayments(new ArrayList<>());
        booking.setPrice(priceCalculator.calculatePrice(show,ShowSeat));
        return booking;
    };
}
