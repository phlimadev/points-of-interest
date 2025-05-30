package br.com.phlimadev.points_of_interest.persistence;

import br.com.phlimadev.points_of_interest.domain.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
}