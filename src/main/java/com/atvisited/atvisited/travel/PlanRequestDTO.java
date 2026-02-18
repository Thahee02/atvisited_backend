package com.atvisited.atvisited.travel;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanRequestDTO {
    private String touristName;
    private LocalDate visitDate;
    private List<PlanItemRequestDTO> places;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class PlanItemRequestDTO {
    private Long placeId;
    private Integer visitOrder;
    private String estimatedArrivalTime; // Format: "HH:mm"
    private Integer estimatedDurationMinutes;
    private String notes;
}
