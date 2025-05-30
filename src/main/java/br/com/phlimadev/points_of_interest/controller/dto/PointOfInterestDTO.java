package br.com.phlimadev.points_of_interest.controller.dto;

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
}
