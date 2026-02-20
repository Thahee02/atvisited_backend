package com.atvisited.atvisited.travel;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanRequestDTO {
    private String title;
    private String touristName;
    private LocalDate visitDate;
    private List<PlanItemRequestDTO> places;
}
