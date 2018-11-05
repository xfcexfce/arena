package com.example.arena.Controller;

import com.example.arena.Creature;
import com.example.arena.CreatureFactory;
import com.example.arena.FightResult;
import com.example.arena.FightService;
import com.example.arena.data.CreatureDto;
import com.example.arena.data.TournamentDto;
import com.example.arena.data.TournamentEntity;
import com.example.arena.data.TournamentRepository;
import com.example.excercise.LambdaExcercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
public class FightController {

    private static Logger logger = Logger.getLogger(FightController.class.getName());

    @Autowired
    FightService fightService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String returnString() {
        return "cos23";
    }

    @RequestMapping("/hello123")
    //podlaczyc repo z lekcji 10 przez @Autowired
    public String hello() {
        throw new NoSuchElementException("No such element exception message");
        // return "Hello world! ";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/hellopostfight")
    public String returnPostString(@RequestParam("id") String personId) {

        System.out.println("ID is " + personId);
        return "ID is " + personId;
    }

    /*@RequestMapping(method = RequestMethod.POST, path = "/hellopostfightbody")
    public String returnPostStringBody(@RequestBody TournamentDto tournamentDto) {

        System.out.println("println ID is " + tournamentDto);

        Integer tournamentCapacity = tournamentDto.getCapacity();
        CreatureFactory creatureFactory = new CreatureFactory();
        FightService fight1 = new FightService();
        LinkedList<Creature> listOfCreatures2 = creatureFactory.randomCreatureList(tournamentCapacity);
        List<Creature[]> listOfPairs = fight1.listOfPairs(listOfCreatures2);
        LinkedList<FightResult> singleTournament = fight1.singleTournament(listOfPairs);
        //zrobic z tournamentdto tournamententity
        TournamentEntity tournamentEntity = new TournamentEntity();
        tournamentEntity.setId(tournamentDto.getId());
        tournamentEntity.setCapacity(tournamentDto.getCapacity());
        LambdaExcercises lambdaExcercises = new LambdaExcercises();
        listOfCreatures2 = lambdaExcercises.sortByNumberOfWins(listOfCreatures2);
        //dodac zeby znalazlo postac z max iloscia wygranych - albo zrobic sortowanie postaci po wygranych punktach
        tournamentEntity.setPoints(listOfCreatures2.get(0).getNumberOfWins());

        tournamentRepository.save(tournamentEntity);

        //odczytac czy sie zapisalo w bazie
        Iterable<TournamentEntity> tournamentEntities = tournamentRepository.findAll();

        //pewnie to co nizej daloby sie sprytniej zrobic?
        Long size = tournamentEntities.spliterator().getExactSizeIfKnown();
        int size2 = Math.toIntExact(size);

        for (int i = 0; i < size2; i++)
            System.out.println("z wewnatrz fora " + tournamentEntities.iterator().next());


        return "ID is " + tournamentDto;
    }*/

    @RequestMapping(method = RequestMethod.POST, path = "/tournaments")
    public TournamentDto returnPostStringBody(@RequestBody @Valid TournamentDto tournamentDto) {

        logger.info("start " + tournamentDto);
        TournamentDto result = fightService.createTournament(tournamentDto);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tournaments")
    public List<TournamentDto> returnTournaments (){
        return fightService.allTournaments();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tournaments/{someid}")
    @ResponseBody
    public TournamentDto returnTournamentId (@PathVariable int someid){
        return fightService.singleTournament(someid);

    }

    @RequestMapping(method = RequestMethod.POST, path = "/creatures")
    public CreatureDto addCreatureToTournament(@RequestBody @Valid CreatureDto creatureDto) {

        logger.info("start " + creatureDto);
        CreatureDto result = fightService.createCreature(creatureDto);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tournaments/{someid}/creatures")
    @ResponseBody
    public void returnPostStringBody(@PathVariable("someid") int id, @RequestBody @Valid CreatureDto creatureDto) {

        logger.info("start " + creatureDto);
        //CreatureDto result = fightService.createCreature(creatureDto);
        //return result;
        //do dokonczenia
    }

    //post dodanie 1 potwora  do turnieju i zeby dzialal na adres tournaments/idturnieju/creatures/
    //tournaments/{id}/creatures/
    //get // post

    //tabelka z creaturami zeby sie stworzyla


    //maven - dependency:tree - pokaze zaleznosci

    //@OneToMany(cascade = CascadeType.ALL
    //https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/


}