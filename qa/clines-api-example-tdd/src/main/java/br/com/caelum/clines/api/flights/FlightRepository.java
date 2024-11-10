package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.shared.domain.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends Repository<Flight, Long> {
    Optional<Flight> findById(Long id);

    List<Flight> findAll();

    @Query(value = "select f from Flight as f" +
            " INNER JOIN f.departure as d " +
            " INNER JOIN d.airport as a " +
            " INNER JOIN a.location as l " +
            " where (cast(:date as date) is null or d.time = :date)" +
            " and (:country is null or l.country = :country)" +
            " and (:state is null or l.state = :state)" +
            " and (:city is null or l.city = :city)")
    List<Flight> findAllBy(@Param("date") LocalDateTime date,
                           @Param("country") String country,
                           @Param("state") String state,
                           @Param("city") String city);

    void save(Flight flight);
}
