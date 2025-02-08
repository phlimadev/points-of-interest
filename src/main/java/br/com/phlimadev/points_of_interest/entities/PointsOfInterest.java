package br.com.phlimadev.points_of_interest.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_points")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PointsOfInterest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
}
