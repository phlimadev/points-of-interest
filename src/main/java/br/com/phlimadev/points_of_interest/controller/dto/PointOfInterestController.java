package br.com.phlimadev.points_of_interest.controller.dto;

import br.com.phlimadev.points_of_interest.business.PointOfInterestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points-of-interest")
@RequiredArgsConstructor
public class PointOfInterestController {
    private final PointOfInterestService service;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody @Valid PointOfInterestDTO body) {
        service.register(body);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PointOfInterestDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<PointOfInterestDTO>> listByProximity(@RequestParam(name = "coordinateX") Integer coordinateX,
                                                                    @RequestParam(name = "coordinateY") Integer coordinateY,
                                                                    @RequestParam(name = "maximumDistance") Double maximumDistance) {
        return ResponseEntity.ok(service.listByProximity(coordinateX, coordinateY, maximumDistance));
    }
}