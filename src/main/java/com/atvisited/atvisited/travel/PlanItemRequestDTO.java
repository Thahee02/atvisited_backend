package com.atvisited.atvisited.travel;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanItemRequestDTO {
    private Long placeId;
    private Integer visitOrder;
    private String estimatedArrivalTime;
    private Integer estimatedDurationMinutes;
    private String notes;
}
