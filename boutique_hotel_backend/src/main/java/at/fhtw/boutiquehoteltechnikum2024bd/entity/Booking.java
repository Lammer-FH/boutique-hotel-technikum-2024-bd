package at.fhtw.boutiquehoteltechnikum2024bd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    @NotNull
    private String email;

    @Column
    private Boolean breakfast;

    @NotNull
    @ManyToOne
    private Room room;

    @NotNull
    private LocalDate checkIn;

    @NotNull
    private LocalDate checkOut;
}