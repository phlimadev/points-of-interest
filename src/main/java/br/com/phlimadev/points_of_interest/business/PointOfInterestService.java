package br.com.phlimadev.points_of_interest.business;

import br.com.phlimadev.points_of_interest.controller.dto.PointOfInterestDTO;
import br.com.phlimadev.points_of_interest.domain.PointOfInterest;
import br.com.phlimadev.points_of_interest.persistence.PointOfInterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointOfInterestService {
    private final PointOfInterestRepository repository;

    public void register(PointOfInterestDTO data) {
        PointOfInterest newPointOfInterest = new PointOfInterest(
                null, data.name(), data.coordinateX(), data.coordinateY(), null, null
        );
        repository.save(newPointOfInterest);
    }

    public List<PointOfInterestDTO> getAll() {
        return repository.findAll().stream().map(PointOfInterestDTO::new).collect(Collectors.toList());
    }

    private List<PointOfInterestDTO> performProximityCalculations(Integer coordinateX, Integer coordinateY, Double maximumDistance) {
        return repository.findAll()
                .stream()
                .filter(point -> {
                    int dx = point.getCoordinateX() - coordinateX;
                    int dy = point.getCoordinateY() - coordinateY;
                    return (dx * dx + dy * dy) <= maximumDistance * maximumDistance;
                })
                .map(PointOfInterestDTO::new)
                .collect(Collectors.toList());
    }

    public List<PointOfInterestDTO> listByProximity(Integer coordinateX, Integer coordinateY, Double maximumDistance) {
        return performProximityCalculations(coordinateX, coordinateY, maximumDistance);
    }
}