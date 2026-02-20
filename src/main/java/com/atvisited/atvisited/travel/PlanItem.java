package com.atvisited.atvisited.travel;

import com.atvisited.atvisited.place.Place;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plan_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_plan_id", nullable = false)
    @JsonIgnore
    private TravelPlan travelPlan;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Column(name = "visit_order")
    private Integer visitOrder;

    @Column(name = "estimated_arrival_time")
    private String estimatedArrivalTime;

    @Column(name = "estimated_duration_minutes")
    private Integer estimatedDurationMinutes;

    private String notes;
}
