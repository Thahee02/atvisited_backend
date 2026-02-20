package com.atvisited.atvisited.travel;

import com.atvisited.atvisited.place.Place;
import com.atvisited.atvisited.place.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelPlanService {

    private final TravelPlanRepository travelPlanRepository;
    private final PlaceRepository placeRepository;

    @Transactional
    public TravelPlanDTO createPlan(PlanRequestDTO request) {
        TravelPlan plan = new TravelPlan();
        plan.setTitle(request.getTitle() != null ? request.getTitle() : "My Trip on " + request.getVisitDate());
        plan.setTouristName(request.getTouristName());
        plan.setVisitDate(request.getVisitDate());
        plan.setIsFinalized(false);

        if (request.getPlaces() != null) {
            for (int i = 0; i < request.getPlaces().size(); i++) {
                PlanItemRequestDTO itemReq = request.getPlaces().get(i);
                Place place = placeRepository.findById(itemReq.getPlaceId())
                        .orElseThrow(() -> new RuntimeException("Place not found: " + itemReq.getPlaceId()));

                PlanItem item = new PlanItem();
                item.setPlace(place);
                item.setVisitOrder(itemReq.getVisitOrder() != null ? itemReq.getVisitOrder() : i + 1);
                item.setEstimatedArrivalTime(itemReq.getEstimatedArrivalTime());
                item.setEstimatedDurationMinutes(itemReq.getEstimatedDurationMinutes());
                item.setNotes(itemReq.getNotes());
                plan.addItem(item);
            }
        }

        TravelPlan savedPlan = travelPlanRepository.save(plan);
        return mapToDTO(savedPlan);
    }

    public List<TravelPlanDTO> getAllPlans() {
        return travelPlanRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TravelPlanDTO getPlanById(Long id) {
        TravelPlan plan = travelPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        return mapToDTO(plan);
    }

    @Transactional
    public void deletePlan(Long id) {
        travelPlanRepository.deleteById(id);
    }

    private TravelPlanDTO mapToDTO(TravelPlan plan) {
        BigDecimal totalCost = plan.getItems().stream()
                .map(item -> item.getPlace().getEstimatedCost() != null ? item.getPlace().getEstimatedCost() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Double totalDistance = plan.getItems().stream()
                .mapToDouble(item -> item.getPlace().getDistanceFromHome() != null ? item.getPlace().getDistanceFromHome() : 0.0)
                .sum();

        List<TravelPlanDTO.PlanItemDTO> itemDTOs = plan.getItems().stream()
                .map(item -> TravelPlanDTO.PlanItemDTO.builder()
                        .id(item.getId())
                        .placeId(item.getPlace().getId())
                        .placeName(item.getPlace().getName())
                        .imageUrl(item.getPlace().getImageUrl())
                        .visitOrder(item.getVisitOrder())
                        .estimatedArrivalTime(item.getEstimatedArrivalTime())
                        .estimatedDurationMinutes(item.getEstimatedDurationMinutes())
                        .notes(item.getNotes())
                        .cost(item.getPlace().getEstimatedCost())
                        .build())
                .collect(Collectors.toList());

        return TravelPlanDTO.builder()
                .id(plan.getId())
                .title(plan.getTitle())
                .touristName(plan.getTouristName())
                .visitDate(plan.getVisitDate())
                .isFinalized(plan.getIsFinalized())
                .items(itemDTOs)
                .totalEstimatedCost(totalCost)
                .totalDistance(totalDistance)
                .build();
    }
}
