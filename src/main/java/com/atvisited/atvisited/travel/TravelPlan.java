package com.atvisited.atvisited.travel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.atvisited.atvisited.auth.User;

@Entity
@Table(name = "travel_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(nullable = false)
    private String title;

    @Column(name = "tourist_name")
    private String touristName;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "is_finalized")
    private Boolean isFinalized = false;

    @OneToMany(mappedBy = "travelPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("visitOrder ASC")
    private List<PlanItem> items = new ArrayList<>();

    public void addItem(PlanItem item) {
        items.add(item);
        item.setTravelPlan(this);
    }
}
