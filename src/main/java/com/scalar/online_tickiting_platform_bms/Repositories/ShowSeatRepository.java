package com.scalar.online_tickiting_platform_bms.Repositories;

import com.scalar.online_tickiting_platform_bms.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> id);
    @Override
    ShowSeat save(ShowSeat ShowSeatEntity);
}