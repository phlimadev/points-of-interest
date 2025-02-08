package br.com.phlimadev.points_of_interest.repositories;

import br.com.phlimadev.points_of_interest.entities.PointsOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsOfInterestRepository extends JpaRepository<PointsOfInterest, Long> {
}
