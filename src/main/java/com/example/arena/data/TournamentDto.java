package com.example.arena.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data //robi geter i setery kostruktory data transfer object
public class TournamentDto {

    private Integer id;
    @NotNull
    @Min(value = 2, message = "minimalna liczba zawodnikow to 2")
    @Max(20)
    private Integer capacity;
    private Integer points;

}


