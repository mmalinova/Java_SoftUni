package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DaysOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    List<Forecast> findAllByDaysOfWeekAndCity_Id(DaysOfWeek daysOfWeek, Long city_id);

    @Query("SELECT f FROM Forecast f WHERE f.daysOfWeek = 'SUNDAY' AND f.city.population < 150000 ORDER BY f.maxTemperature DESC, f.id ASC")
    List<Forecast> findAllWantedForecasts();
}
