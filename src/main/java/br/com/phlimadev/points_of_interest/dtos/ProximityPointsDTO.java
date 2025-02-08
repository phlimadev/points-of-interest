package br.com.phlimadev.points_of_interest.dtos;

import br.com.phlimadev.points_of_interest.entities.PointsOfInterest;

public record ProximityPointsDTO(String name, Integer coordinateX, Integer coordinateY) {
    public ProximityPointsDTO(PointsOfInterest pointsOfInterest) {
        this(pointsOfInterest.getName(), pointsOfInterest.getCoordinateX(), pointsOfInterest.getCoordinateY());
    }
}
