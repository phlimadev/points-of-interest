package br.com.phlimadev.points_of_interest.dtos;

import br.com.phlimadev.points_of_interest.entities.PointsOfInterest;

public record AllPointsDTO(Long id, String name, Integer coordinateX, Integer coordinateY) {
    public AllPointsDTO(PointsOfInterest pointsOfInterest) {
        this(pointsOfInterest.getId(), pointsOfInterest.getName(), pointsOfInterest.getCoordinateX(), pointsOfInterest.getCoordinateY());
    }
}
