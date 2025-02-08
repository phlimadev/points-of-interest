package br.com.phlimadev.points_of_interest.services;

import br.com.phlimadev.points_of_interest.infra.exceptions.NegativeCoordinateException;
import org.springframework.stereotype.Service;

@Service
public class PointsOfInterestService {
    public void validate(Integer coordinateX, Integer coordinateY) {
        if (coordinateX < 0 || coordinateY < 0) {
            throw new NegativeCoordinateException("Both coordinates must be positive.");
        }
    }
}
