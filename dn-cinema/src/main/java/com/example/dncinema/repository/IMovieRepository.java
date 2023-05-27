package com.example.dncinema.repository;

import com.example.dncinema.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface IMovieRepository extends JpaRepository<Film, Integer> {
    @Query(value = "select actor,describe_film, director, img_film, name_film, trailer, name_type_film  from film where name_film like concat('%', :search, '%')", nativeQuery = true)
    Page<Film> findAllFilm(@Param("search") String search ,Pageable pageable);


    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @param id
     * @return findFilmById
     * @Usage_method findById to show detail film
     */
    @Query(value = "select * from film " +
            "join type_film on film.id_type_film = type_film.id_type_film " +
            "join show_time st on st.id_show_time = film.id_show_time" +
            " where film.id_film = :id ", nativeQuery = true)
    Film findFilmById(@Param("id") Integer id);
}
