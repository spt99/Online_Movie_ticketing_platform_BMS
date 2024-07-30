package com.scalar.online_tickiting_platform_bms.Repositories;

import com.scalar.online_tickiting_platform_bms.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
    // select queries will come
    // spring data jpa

}