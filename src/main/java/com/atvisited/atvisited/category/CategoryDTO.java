package com.atvisited.atvisited.category;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private String iconUrl;
    private Long placeCount; // number of places in this category
}
