package com.example.arena.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //oznacza ze ma byc zapis do bazy
@Data //robi geter i setery kostruktory
public class TournamentDto {
    @Id //tworzy kolumny id i generatedvalues i capacity i points
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer capacity;
    private Integer points;

}


