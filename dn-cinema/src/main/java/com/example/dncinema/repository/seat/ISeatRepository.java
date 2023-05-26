package com.example.dncinema.repository.seat;

import com.example.dncinema.model.Film;
import com.example.dncinema.model.Seat;
import com.example.dncinema.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Integer> {
    @Query(value = "select * from seat where id_show_room = :id", nativeQuery = true)
    List<Seat> findAllListSeatByIdRoom(@Param("id") Integer id);


}
