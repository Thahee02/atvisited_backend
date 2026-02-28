package com.atvisited.atvisited.admin;

import com.atvisited.atvisited.auth.UserRepository;
import com.atvisited.atvisited.category.CategoryRepository;
import com.atvisited.atvisited.place.PlaceRepository;
import com.atvisited.atvisited.travel.TravelPlanRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/stats")
@RequiredArgsConstructor
public class DashboardController {

    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final TravelPlanRepository travelPlanRepository;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<AdminStatsResponse> getStats() {
        return ResponseEntity.ok(AdminStatsResponse.builder()
                .totalPlaces(placeRepository.count())
                .totalCategories(categoryRepository.count())
                .totalPlans(travelPlanRepository.count())
                .totalUsers(userRepository.count())
                .build());
    }

    @Data
    @Builder
    public static class AdminStatsResponse {
        private long totalPlaces;
        private long totalCategories;
        private long totalPlans;
        private long totalUsers;
    }
}
