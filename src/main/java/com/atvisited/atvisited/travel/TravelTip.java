package com.atvisited.atvisited.travel;

import com.atvisited.atvisited.place.Place;
import com.atvisited.atvisited.utils.TipType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "travel_tips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Column(nullable = false, length = 500)
    private String tip;

    @Enumerated(EnumType.STRING)
    private TipType tipType;
}
