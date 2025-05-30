package br.com.phlimadev.points_of_interest.controller.dto;

import br.com.phlimadev.points_of_interest.domain.PointOfInterest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record PointOfInterestDTO(
        @NotBlank
        @Size(max = 50)
        String name,
        @NotNull
        @PositiveOrZero
        Integer coordinateX,
        @NotNull
        @PositiveOrZero
        Integer coordinateY
) {
        public PointOfInterestDTO(PointOfInterest entity) {
                this(entity.getName(), entity.getCoordinateX(), entity.getCoordinateY());
        }
}