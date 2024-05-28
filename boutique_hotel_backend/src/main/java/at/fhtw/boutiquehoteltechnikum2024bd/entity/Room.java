package at.fhtw.boutiquehoteltechnikum2024bd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hotel_room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private int bedcount;

    @Column(nullable = false)
    private float price;

    @Column
    private String extras;

    private String images;


}
