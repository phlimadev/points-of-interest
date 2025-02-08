package br.com.phlimadev.points_of_interest.services;

import br.com.phlimadev.points_of_interest.dtos.AllPointsDTO;
import br.com.phlimadev.points_of_interest.dtos.ProximityPointsDTO;
import br.com.phlimadev.points_of_interest.dtos.RequestProximityPointsDTO;
import br.com.phlimadev.points_of_interest.dtos.RegisterDTO;
import br.com.phlimadev.points_of_interest.entities.PointsOfInterest;
import br.com.phlimadev.points_of_interest.infra.exceptions.NegativeCoordinateException;
import br.com.phlimadev.points_of_interest.repositories.PointsOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<AllPointsDTO> searchAllPoints() {
        List<AllPointsDTO> allPoints = pointsOfInterestRepository.findAll().stream().map(AllPointsDTO::new).toList();
        return allPoints;
    }

    public List<ProximityPointsDTO> searchForProximity(RequestProximityPointsDTO data) {
        List<ProximityPointsDTO> filteredList = pointsOfInterestRepository
                .findAll()
                .stream()
                .map(ProximityPointsDTO::new)
                .filter(point ->
                        Math.sqrt(Math.pow(point.coordinateX() - data.coordinateX(), 2) +
                                Math.pow(point.coordinateY() - data.coordinateY(), 2))
                                <= data.maximumDistance())
                .toList();
        return filteredList;
    }
}
