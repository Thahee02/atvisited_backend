package com.atvisited.atvisited.travel;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
@RequiredArgsConstructor
public class TravelPlanController {


    private final TravelPlanService travelPlanService;

    @PostMapping
    public ResponseEntity<TravelPlanDTO> createPlan(@RequestBody PlanRequestDTO request) {
        String userEmail = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        return new ResponseEntity<>(travelPlanService.createPlan(request, userEmail), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TravelPlanDTO>> getAllPlans() {
        String userEmail = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(travelPlanService.getPlansForUser(userEmail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPlanDTO> getPlanById(@PathVariable Long id) {
        String userEmail = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(travelPlanService.getPlanById(id, userEmail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        String userEmail = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        travelPlanService.deletePlan(id, userEmail);
        return ResponseEntity.noContent().build();
    }

}
