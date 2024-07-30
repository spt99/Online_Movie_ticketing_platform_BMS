package com.scalar.online_tickiting_platform_bms.Repositories;

import com.scalar.online_tickiting_platform_bms.models.Show;
import com.scalar.online_tickiting_platform_bms.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);
    // sql queries


}
