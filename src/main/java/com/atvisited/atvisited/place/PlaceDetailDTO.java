package com.atvisited.atvisited.place;

import com.atvisited.atvisited.review.ReviewDTO;
import com.atvisited.atvisited.travel.TravelTipDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDetailDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String description;
    private Double latitude;
    private Double longitude;
    private String address;
    private Double distanceFromHome;
    private BigDecimal estimatedCost;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String bestTimeToVisit;
    private String contactNumber;
    private String websiteUrl;
    private String accessibilityInfo;
    private Boolean parkingAvailable;
    private String imageUrl;
    private Double rating;
    private String historicalBackground;
    private String culturalSignificance;
    private String transportOptions;
    private String safetyGuidelines;
    private String localCustoms;
    private String nearbyFacilities;
    private String suitableFor;
    private Boolean washroomsAvailable;
    private String estimatedVisitDuration;

    // Nested objects
    private List<TravelTipDTO> travelTips;
    private List<ReviewDTO> reviews;
}
