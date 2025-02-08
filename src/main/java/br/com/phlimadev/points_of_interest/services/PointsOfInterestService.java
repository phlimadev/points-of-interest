package br.com.phlimadev.points_of_interest.services;

import br.com.phlimadev.points_of_interest.dtos.RegisterDTO;
import br.com.phlimadev.points_of_interest.entities.PointsOfInterest;
import br.com.phlimadev.points_of_interest.infra.exceptions.NegativeCoordinateException;
import br.com.phlimadev.points_of_interest.repositories.PointsOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsOfInterestService {
    @Autowired
    private PointsOfInterestRepository pointsOfInterestRepository;

    public void validate(Integer coordinateX, Integer coordinateY) {
        if (coordinateX < 0 || coordinateY < 0) {
            throw new NegativeCoordinateException("Both coordinates must be positive.");
        }
    }

    public void register(RegisterDTO register) {
        validate(register.coordinateX(), register.coordinateY());
        PointsOfInterest newPoint = new PointsOfInterest(register);
        pointsOfInterestRepository.save(newPoint);
    }
}
