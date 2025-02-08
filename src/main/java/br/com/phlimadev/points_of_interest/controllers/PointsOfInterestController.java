package br.com.phlimadev.points_of_interest.controllers;

import br.com.phlimadev.points_of_interest.dtos.AllPointsDTO;
import br.com.phlimadev.points_of_interest.dtos.ProximityPointsDTO;
import br.com.phlimadev.points_of_interest.dtos.RegisterDTO;
import br.com.phlimadev.points_of_interest.dtos.RequestProximityPointsDTO;
import br.com.phlimadev.points_of_interest.services.PointsOfInterestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points-of-interest")
public class PointsOfInterestController {
    @Autowired
    private PointsOfInterestService pointsOfInterestService;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid RegisterDTO register) {
        pointsOfInterestService.register(register);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AllPointsDTO>> findAll() {
        List<AllPointsDTO> allPoints = pointsOfInterestService.searchAllPoints();
        return ResponseEntity.ok(allPoints);
    }

    @GetMapping("/proximity")
    public ResponseEntity<List<ProximityPointsDTO>> searchForProximity(@RequestBody @Valid RequestProximityPointsDTO data) {
        List<ProximityPointsDTO> result = pointsOfInterestService.searchForProximity(data);
        return ResponseEntity.ok(result);
    }
}
