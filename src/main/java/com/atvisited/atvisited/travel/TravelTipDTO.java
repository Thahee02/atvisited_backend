package com.atvisited.atvisited.travel;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelTipDTO {
    private Long id;
    private String tip;
    private String tipType;
}