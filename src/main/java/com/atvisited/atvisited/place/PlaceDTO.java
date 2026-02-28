package com.atvisited.atvisited.place;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String description;
    private Double distanceFromHome;
    private BigDecimal estimatedCost;
    private String imageUrl;
    private Double rating;
    private String bestTimeToVisit;

    // For map display
    private Double latitude;
    private Double longitude;
}
