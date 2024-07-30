package com.scalar.online_tickiting_platform_bms.services;

import com.scalar.online_tickiting_platform_bms.Repositories.ShowSeatRepository;
import com.scalar.online_tickiting_platform_bms.Repositories.ShowSeatTypeRepository;
import com.scalar.online_tickiting_platform_bms.models.Show;
import com.scalar.online_tickiting_platform_bms.models.ShowSeat;
import com.scalar.online_tickiting_platform_bms.models.ShowSeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private PriceCalculatorService priceCalculator;
    private ShowSeatTypeRepository showSeatTypeRepository;

    public int calculatePrice(Show show, List<ShowSeat> showSeat)
    {
        // get show seat type for given show
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
       // show seat a1, a2, a3
        // seat type gold, recliner, balcony
        // 2. get type of input show seat
        int price = 0;
        for(ShowSeat showSeat2 : showSeat)
        {
            for(ShowSeatType showSeatTypes2: showSeatTypes)
            {
                if(showSeat2.getSeat().getSeatType().equals(showSeatTypes2.getSeatType())) {
                price +=showSeatTypes2.getPrice();
                break;
                }

            }
        }
        // 3 add a corresponding price
        return price;
    }

}
