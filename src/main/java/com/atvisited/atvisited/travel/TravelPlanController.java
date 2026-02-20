package com.atvisited.atvisited.travel;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TravelPlanController {

    private final TravelPlanService travelPlanService;

    @PostMapping
    public ResponseEntity<TravelPlanDTO> createPlan(@RequestBody PlanRequestDTO request) {
        return new ResponseEntity<>(travelPlanService.createPlan(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TravelPlanDTO>> getAllPlans() {
        return ResponseEntity.ok(travelPlanService.getAllPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPlanDTO> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(travelPlanService.getPlanById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        travelPlanService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
