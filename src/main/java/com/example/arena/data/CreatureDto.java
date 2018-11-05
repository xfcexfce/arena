package com.example.arena.data;

import com.example.arena.Armour;
import com.example.arena.BodyPart;
import com.example.arena.CreatureType;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

@Data
public class CreatureDto {
    private Integer id;

    //private CreatureType creatureType;
    private Integer strength;
    private Integer dexterity;
    private Integer defence;
    private Integer endurance;
    private Integer lifePoints;
    private String name;
    private Integer totalValueOfSDDEL;
    private Integer numberOfWins;
    //private Map<BodyPart, Integer> bodyPartHitNumber;
    //private Set<Armour> armourList;


    //private Integer capacity;
    //private Integer points;
}
