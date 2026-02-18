package com.atvisited.atvisited.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    // Find places by category
    List<Place> findByCategoryId(Long categoryId);

    // Find places within distance
    List<Place> findByDistanceFromHomeLessThanEqual(Double maxDistance);

    // Search places by name or description
    @Query("SELECT p FROM Place p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Place> searchPlaces(@Param("keyword") String keyword);

    // Find places with rating above certain value
    @Query("SELECT p FROM Place p WHERE p.rating >= :minRating")
    List<Place> findByMinRating(@Param("minRating") Double minRating);
}
