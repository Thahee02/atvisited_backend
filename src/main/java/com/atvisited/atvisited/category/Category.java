package com.atvisited.atvisited.category;

import com.atvisited.atvisited.place.Place;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
    private String iconUrl;

    // One category can have many places
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Place> places;
}
