package br.com.phlimadev.points_of_interest.business;

import br.com.phlimadev.points_of_interest.controller.dto.PointOfInterestDTO;
import br.com.phlimadev.points_of_interest.domain.PointOfInterest;
import br.com.phlimadev.points_of_interest.persistence.PointOfInterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}