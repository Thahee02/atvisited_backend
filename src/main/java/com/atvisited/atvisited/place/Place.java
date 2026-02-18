package com.atvisited.atvisited.place;

import com.atvisited.atvisited.category.Category;
import com.atvisited.atvisited.review.Review;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import com.atvisited.atvisited.travel.TravelTip;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private String address;

    @Column(name = "distance_from_home")
    private Double distanceFromHome; // in km

    @Column(name = "estimated_cost")
    private BigDecimal estimatedCost; // in LKR

    @Column(name = "opening_time")
    private LocalTime openingTime;

    @Column(name = "closing_time")
    private LocalTime closingTime;

    @Column(name = "best_time_to_visit")
    private String bestTimeToVisit;

    private String contactNumber;

    private String websiteUrl;

    @Column(length = 500)
    private String accessibilityInfo;

    @Column(name = "parking_available")
    private Boolean parkingAvailable = false;

    @Column(name = "image_url")
    private String imageUrl;

    private Double rating = 0.0;

    // Relationships
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<TravelTip> travelTips;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
