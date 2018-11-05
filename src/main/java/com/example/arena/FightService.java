
package com.example.arena;

import com.example.arena.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

@Service
public class FightService {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    CreatureRepository creatureRepository;

    public LinkedList<FightResult> fight(Creature c1, Creature c2) {
        LinkedList<FightResult> fightResultList = new LinkedList<>();
        FightResult fightResultBeforeRealFight = new FightResult(c1, c2, null); //stan poczatkowy
        fightResultList.add(fightResultBeforeRealFight);
        while (c1.getLifePoints() > 0 && c2.getLifePoints() > 0) {
            AttackResult attackResultFromC1 = c1.attack();
            System.out.println("Potential attack from C1 (before dodge): BodyPart " + attackResultFromC1.bodyPart +
                    " Attack was finished with success: " + attackResultFromC1.successAttack +
                    " Hit number: " + attackResultFromC1.hitNumber + " Numer of try: " +
                    attackResultFromC1.numberOfTry + " Final (potential) damage " + attackResultFromC1.finalDamage +
                    "Final (potential) damage: " + attackResultFromC1.potentialDamage);
            if (attackResultFromC1.successAttack == true) {
                attackResultFromC1 = c2.dodge(attackResultFromC1);
                FightResult fightResult = new FightResult(c1, c2, attackResultFromC1); //tu stworzyc kopie c1 i c2
                fightResultList.add(fightResult);
            }
            if (c2.getLifePoints() > 0 && c1.getLifePoints() > 0) {
                AttackResult attackResultFromC2 = c2.attack();
                System.out.println("Atak od C2 " + attackResultFromC2.potentialDamage);
                if (attackResultFromC2.successAttack == true) {
                    c1.dodge(attackResultFromC2);
                    FightResult fightResult = new FightResult(c1, c2, attackResultFromC2);
                    fightResultList.add(fightResult);
                }
            }
            System.out.println("C1 ma punkty zycia " + c1.getLifePoints() + "C2 ma punkty zycia " + c2.getLifePoints());
        }
        return fightResultList;
    }

    public List<Creature[]> listOfPairs(LinkedList<Creature> listOfCreatures) {
        List<Creature[]> pairs = new ArrayList<>();
        for (int i = 0; i < listOfCreatures.size(); ++i)
            for (int j = i + 1; j < listOfCreatures.size(); ++j)
                pairs.add(new Creature[]{listOfCreatures.get(i), listOfCreatures.get(j)});
        return pairs;
    }

    public LinkedList<FightResult> singleTournament(List<Creature[]> listOfPairs) {
        LinkedList<FightResult> singleTournament = new LinkedList<>();
        for (int i = 0; i < listOfPairs.size(); i++) {
            Creature[] cpair = listOfPairs.get(i);
            Creature cc1 = cpair[0]; //to dalej jest wskaznik do tego samego Creature - wiec potrzeba zrobic tu kopie obiektu zamiast nowego wskaznika
            Creature cc2 = cpair[1];
            LinkedList<FightResult> fightResult2 = fight(cc1, cc2);
            FightResult lastFightResult = fightResult2.getLast();
            if (lastFightResult.c1.getLifePoints() < 1)
                lastFightResult.c2.numberOfWins++;
            else
                lastFightResult.c1.numberOfWins++;
            singleTournament.add(lastFightResult);
        }
        return singleTournament;
    }

    public List<TournamentDto> allTournaments() {
        Iterable<TournamentEntity> all = tournamentRepository.findAll();
        LinkedList<TournamentDto> result = new LinkedList<>();
        Iterator<TournamentEntity> iterator = all.iterator();
        all.forEach(tournamentEntity -> result.add(entityToDto(tournamentEntity)));
        /*all.forEach(new Consumer<TournamentEntity>() {
            @Override
            public void accept(TournamentEntity tournamentEntity) {
                result.add(entityToDto(tournamentEntity));
            }
        });
        while (iterator.hasNext()) {
            TournamentEntity entity = iterator.next();
            TournamentDto dto = entityToDto(entity);
            result.add(dto);
        }*/
        return result;

    }

    public TournamentDto singleTournament(int id) {
        Iterable<TournamentEntity> all = tournamentRepository.findAll();
        //jak chcialem zrobic bez listy to nie dialalo... :/
        LinkedList<TournamentDto> result = new LinkedList<>();
        TournamentDto singleResult = new TournamentDto();
        /* all.forEach(new Consumer<TournamentEntity>() {
            @Override
            public void accept(TournamentEntity tournamentEntity) {
                if (tournamentEntity.getId() == id) {
                    result.add(entityToDto(tournamentEntity));
                    TournamentDto singleR = entityToDto(tournamentEntity);
                    //singleResult = singleR; //???
                }
            }
        });*/

        Iterator<TournamentEntity> iterator = all.iterator();
        //all.forEach(tournamentEntity -> result.add(entityToDto(tournamentEntity)));

        while (iterator.hasNext()) {
            TournamentEntity entity = iterator.next();
            TournamentDto dto = entityToDto(entity);
            if (entity.getId() == id){
                singleResult = dto;
                result.add(dto);
            }
        }
        return singleResult;
        //return result.getFirst();

    }

    public TournamentDto createTournament(TournamentDto tournamentDto) {
        TournamentEntity tournamentEntity = dtoToEntity(tournamentDto);
        TournamentEntity saved = tournamentRepository.save(tournamentEntity);
        TournamentDto result = entityToDto(saved);
        return result;
    }

    public CreatureDto createCreature(CreatureDto creatureDto) {
        CreatureEntity creatureEntity = dtoToEntity(creatureDto);
        CreatureEntity saved = creatureRepository.save(creatureEntity);
        CreatureDto result = entityToDto(saved);
        return result;
    }

    public TournamentEntity dtoToEntity(TournamentDto tournamentDto) {
        TournamentEntity tournamentEntity = new TournamentEntity();
        tournamentEntity.setCapacity(tournamentDto.getCapacity());
        tournamentEntity.setPoints(tournamentDto.getPoints());
        return tournamentEntity;
    }

    public TournamentDto entityToDto(TournamentEntity entity) {
        TournamentDto dto = new TournamentDto();
        dto.setCapacity(entity.getCapacity());
        dto.setPoints(entity.getPoints());
        dto.setId(entity.getId());
        return dto;
    }

    public CreatureEntity dtoToEntity(CreatureDto creatureDto) {
        CreatureEntity creatureEntity = new CreatureEntity();
        creatureEntity.setName(creatureDto.getName());
        creatureEntity.setDefence(creatureDto.getDefence());
        return creatureEntity;
    }

    public CreatureDto entityToDto(CreatureEntity entity) {
        CreatureDto dto = new CreatureDto();
        dto.setName(entity.getName());
        dto.setDefence(entity.getDefence());
        dto.setId(entity.getId());
        return dto;
    }
}