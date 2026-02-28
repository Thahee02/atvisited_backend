package com.atvisited.atvisited.travel;

import com.atvisited.atvisited.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
    List<TravelPlan> findByUser(User user);
    List<TravelPlan> findByUserEmail(String email);
    Optional<TravelPlan> findByIdAndUserEmail(Long id, String email);
}

