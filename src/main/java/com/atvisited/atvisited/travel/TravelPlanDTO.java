package com.atvisited.atvisited.travel;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelPlanDTO {
    private Long id;
    private String title;
    private String touristName;
    private LocalDate visitDate;
    private Boolean isFinalized;
    private List<PlanItemDTO> items;
    private BigDecimal totalEstimatedCost;
    private Double totalDistance;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PlanItemDTO {
        private Long id;
        private Long placeId;
        private String placeName;
        private String imageUrl;
        private Integer visitOrder;
        private String estimatedArrivalTime;
        private Integer estimatedDurationMinutes;
        private String notes;
        private BigDecimal cost;
    }
}
