package com.example.arena.data;

import com.example.arena.Armour;
import com.example.arena.BodyPart;
import com.example.arena.CreatureType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;
import java.util.Set;

@Entity //oznacza ze ma byc zapis do bazy
@Data //robi geter i setery kostruktory
public class CreatureEntity {
    @Id //tworzy kolumny id i generatedvalues i capacity i points
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //private CreatureType creatureType;
    //private Integer strength;
    //private Integer dexterity;
    private Integer defence;
    //private Integer endurance;
    //private Integer lifePoints;
    private String name;
    //private Integer totalValueOfSDDEL;
    //private Integer numberOfWins;
    //private Map<BodyPart, Integer> bodyPartHitNumber;
    //private Set<Armour> armourList;




    //private Integer id;
    //private Integer capacity;
    //private Integer points;

}
