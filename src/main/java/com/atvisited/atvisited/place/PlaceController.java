package com.atvisited.atvisited.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    // GET all places
    @GetMapping
    public ResponseEntity<List<PlaceDTO>> getAllPlaces() {
        return ResponseEntity.ok(placeService.getAllPlaces());
    }

    // GET place by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlaceDetailDTO> getPlaceById(@PathVariable Long id) {
        return ResponseEntity.ok(placeService.getPlaceById(id));
    }

    // GET places by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PlaceDTO>> getPlacesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(placeService.getPlacesByCategory(categoryId));
    }

    // GET places within distance
    @GetMapping("/nearby")
    public ResponseEntity<List<PlaceDTO>> getNearbyPlaces(
            @RequestParam(defaultValue = "25") Double radius) {
        return ResponseEntity.ok(placeService.getPlacesWithinDistance(radius));
    }

    // GET search places
    @GetMapping("/search")
    public ResponseEntity<List<PlaceDTO>> searchPlaces(
            @RequestParam String keyword) {
        return ResponseEntity.ok(placeService.searchPlaces(keyword));
    }

    // POST create new place
    @PostMapping
    public ResponseEntity<PlaceDetailDTO> createPlace(@RequestBody PlaceDetailDTO placeDTO) {
        PlaceDetailDTO created = placeService.createPlace(placeDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT update place
    @PutMapping("/{id}")
    public ResponseEntity<PlaceDetailDTO> updatePlace(
            @PathVariable Long id,
            @RequestBody PlaceDetailDTO placeDTO) {
        return ResponseEntity.ok(placeService.updatePlace(id, placeDTO));
    }

    // DELETE place
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}
