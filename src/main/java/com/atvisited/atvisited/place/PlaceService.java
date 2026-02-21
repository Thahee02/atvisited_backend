package com.atvisited.atvisited.place;

import com.atvisited.atvisited.category.Category;
import com.atvisited.atvisited.category.CategoryRepository;
import com.atvisited.atvisited.review.Review;
import com.atvisited.atvisited.review.ReviewDTO;
import com.atvisited.atvisited.travel.TravelTip;
import com.atvisited.atvisited.travel.TravelTipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<PlaceDTO> getAllPlaces() {
        return placeRepository.findAll().stream()
                .map(this::convertToListDTO)
                .collect(Collectors.toList());
    }

    public PlaceDetailDTO getPlaceById(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found with id: " + id));
        return convertToDetailDTO(place);
    }

    public List<PlaceDTO> getPlacesByCategory(Long categoryId) {
        return placeRepository.findByCategoryId(categoryId).stream()
                .map(this::convertToListDTO)
                .collect(Collectors.toList());
    }

    public List<PlaceDTO> searchPlaces(String keyword) {
        return placeRepository.searchPlaces(keyword).stream()
                .map(this::convertToListDTO)
                .collect(Collectors.toList());
    }

    public List<PlaceDTO> getPlacesWithinDistance(Double maxDistance) {
        return placeRepository.findByDistanceFromHomeLessThanEqual(maxDistance).stream()
                .map(this::convertToListDTO)
                .collect(Collectors.toList());
    }

    public PlaceDetailDTO createPlace(PlaceDetailDTO placeDTO) {
        Place place = new Place();
        updatePlaceFromDTO(place, placeDTO);

        Place savedPlace = placeRepository.save(place);
        return convertToDetailDTO(savedPlace);
    }

    public PlaceDetailDTO updatePlace(Long id, PlaceDetailDTO placeDTO) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found with id: " + id));

        updatePlaceFromDTO(place, placeDTO);
        Place updatedPlace = placeRepository.save(place);
        return convertToDetailDTO(updatedPlace);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    // Helper methods for conversion
    private PlaceDTO convertToListDTO(Place place) {
        PlaceDTO dto = new PlaceDTO();
        dto.setId(place.getId());
        dto.setName(place.getName());
        dto.setCategoryName(place.getCategory().getName());
        dto.setDescription(place.getDescription());
        dto.setDistanceFromHome(place.getDistanceFromHome());
        dto.setEstimatedCost(place.getEstimatedCost());
        dto.setImageUrl(place.getImageUrl());
        dto.setRating(place.getRating());
        dto.setBestTimeToVisit(place.getBestTimeToVisit());
        dto.setLatitude(place.getLatitude());
        dto.setLongitude(place.getLongitude());
        return dto;
    }

    private PlaceDetailDTO convertToDetailDTO(Place place) {
        PlaceDetailDTO dto = new PlaceDetailDTO();
        dto.setId(place.getId());
        dto.setName(place.getName());
        dto.setCategoryName(place.getCategory().getName());
        dto.setDescription(place.getDescription());
        dto.setLatitude(place.getLatitude());
        dto.setLongitude(place.getLongitude());
        dto.setAddress(place.getAddress());
        dto.setDistanceFromHome(place.getDistanceFromHome());
        dto.setEstimatedCost(place.getEstimatedCost());
        dto.setOpeningTime(place.getOpeningTime());
        dto.setClosingTime(place.getClosingTime());
        dto.setBestTimeToVisit(place.getBestTimeToVisit());
        dto.setContactNumber(place.getContactNumber());
        dto.setWebsiteUrl(place.getWebsiteUrl());
        dto.setAccessibilityInfo(place.getAccessibilityInfo());
        dto.setParkingAvailable(place.getParkingAvailable());
        dto.setImageUrl(place.getImageUrl());
        dto.setRating(place.getRating());
        dto.setHistoricalBackground(place.getHistoricalBackground());
        dto.setCulturalSignificance(place.getCulturalSignificance());
        dto.setTransportOptions(place.getTransportOptions());
        dto.setSafetyGuidelines(place.getSafetyGuidelines());
        dto.setLocalCustoms(place.getLocalCustoms());
        dto.setNearbyFacilities(place.getNearbyFacilities());
        dto.setSuitableFor(place.getSuitableFor());
        dto.setWashroomsAvailable(place.getWashroomsAvailable());
        dto.setEstimatedVisitDuration(place.getEstimatedVisitDuration());

        // Convert travel tips
        if (place.getTravelTips() != null) {
            dto.setTravelTips(place.getTravelTips().stream()
                .map(this::convertToTipDTO)
                .collect(Collectors.toList()));
        }

        // Convert reviews
        if (place.getReviews() != null) {
            dto.setReviews(place.getReviews().stream()
                .map(this::convertToReviewDTO)
                .collect(Collectors.toList()));
        }

        return dto;
    }

    private TravelTipDTO convertToTipDTO(TravelTip tip) {
        TravelTipDTO dto = new TravelTipDTO();
        dto.setId(tip.getId());
        dto.setTip(tip.getTip());
        dto.setTipType(tip.getTipType().toString());
        return dto;
    }

    private ReviewDTO convertToReviewDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setReviewerName(review.getReviewerName());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreatedAt());
        return dto;
    }

    private void updatePlaceFromDTO(Place place, PlaceDetailDTO dto) {
        place.setName(dto.getName());

        // Set category
        Category category = categoryRepository.findByName(dto.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found: " + dto.getCategoryName()));
        place.setCategory(category);

        place.setDescription(dto.getDescription());
        place.setLatitude(dto.getLatitude());
        place.setLongitude(dto.getLongitude());
        place.setAddress(dto.getAddress());
        place.setDistanceFromHome(dto.getDistanceFromHome());
        place.setEstimatedCost(dto.getEstimatedCost());
        place.setOpeningTime(dto.getOpeningTime());
        place.setClosingTime(dto.getClosingTime());
        place.setBestTimeToVisit(dto.getBestTimeToVisit());
        place.setContactNumber(dto.getContactNumber());
        place.setWebsiteUrl(dto.getWebsiteUrl());
        place.setAccessibilityInfo(dto.getAccessibilityInfo());
        place.setParkingAvailable(dto.getParkingAvailable());
        place.setImageUrl(dto.getImageUrl());
        place.setHistoricalBackground(dto.getHistoricalBackground());
        place.setCulturalSignificance(dto.getCulturalSignificance());
        place.setTransportOptions(dto.getTransportOptions());
        place.setSafetyGuidelines(dto.getSafetyGuidelines());
        place.setLocalCustoms(dto.getLocalCustoms());
        place.setNearbyFacilities(dto.getNearbyFacilities());
        place.setSuitableFor(dto.getSuitableFor());
        place.setWashroomsAvailable(dto.getWashroomsAvailable());
        place.setEstimatedVisitDuration(dto.getEstimatedVisitDuration());
    }
}