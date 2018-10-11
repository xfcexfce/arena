package com.example.arena;

import lombok.Getter;

import java.util.*;

@Getter
public class Creature implements Fightable {

    CreatureType creatureType;
    private Integer strength;
    private Integer dexterity;
    private Integer defence;
    private Integer endurance;
    private Integer lifePoints;
    private String name;
    private Integer totalValueOfSDDEL;
    Integer numberOfWins;
    Map<BodyPart, Integer> bodyPartHitNumber;
    Set<Armour> armourList;


    private UtilitiesMain utilitiesMain = new UtilitiesMain();

    public void setUtilitiesMain(UtilitiesMain utilitiesMain) {
        this.utilitiesMain = utilitiesMain;
    }


    public void setTotalValueOfSDDEL(Integer totalValueOfSDDEL) {
        this.totalValueOfSDDEL = totalValueOfSDDEL;
    }

    public Integer getTotalValueOfSDDEL() {
        return totalValueOfSDDEL;
    }

    //gettery sa public - to poprawne??  ---  te strzaleczki tutaj pokazuja metody od uzycia Lomboka ???



    public Creature(CreatureType creatureType, Integer strength, Integer dexterity, Integer defence, Integer endurance, Integer lifePoints) {
        this.creatureType = creatureType;
        this.strength = strength;
        this.dexterity = dexterity;
        this.defence = defence;
        this.endurance = endurance;
        this.lifePoints = lifePoints;
        this.bodyPartHitNumber = new HashMap<>();
        this.armourList = generateRandomArmourSet();
        RandomName randomName = new RandomName();
        this.name = randomName.generateName();
        this.numberOfWins = 0;
    }

    Set<Armour> generateRandomArmourSet() {
        Set<Armour> armourSet = new HashSet<>();
        int armourNumber = random(1, 5);
        LinkedList<Armour> listOfAllArmours = new LinkedList<>();
        listOfAllArmours.addAll(Arrays.asList(Armour.values()));
        int j = 0;
        while (j < armourNumber) {
            int randomValue = random(0, listOfAllArmours.size() - 1);
            armourSet.add(listOfAllArmours.get(randomValue));
            listOfAllArmours.remove(randomValue);
            j++;
        }
        return armourSet;
    }

    public AttackResult attack() {
        boolean successAttack = false;
        int randomDexterity = random(1, 10);
        BodyPart hitPartName = null;
        int numberOfTry = 1;
        Optional<BodyPart> optionalHitPartNameTry1 = trafionaCzesc();
        // optionalHitPartNameTry1.ifPresent(bodyPart -> System.out.println("HIT"));

        if (optionalHitPartNameTry1.isPresent()) {
            hitPartName = optionalHitPartNameTry1.get();
        } else {
            numberOfTry++;
            Optional<BodyPart> optionalHitPartNameTry2 = trafionaCzesc();
            if (optionalHitPartNameTry2.isPresent()) {
                hitPartName = optionalHitPartNameTry2.get();
            } else {
                AttackResult attackResult = new AttackResult(hitPartName, 0, numberOfTry, successAttack);
// pewnie lepiej stworzyc obiekt na poczatku i uzueplniac go niz miec 3 deklaracje stworzenia obiektu??
                return attackResult;
            }
        }
        successAttack = true;
        int randomObrazenia = this.strength + random(1, 3);
        randomObrazenia = randomObrazenia + hitPartName.PremiaZaTrafienie();


        if (this.getDexterity() > randomDexterity) {
            System.out.println("Atak sie powiodl. Otrzymane obrazenia byly z zakresu od " + this.strength + " do: " + randomObrazenia);
            AttackResult attackResult = new AttackResult(hitPartName, randomObrazenia, numberOfTry, successAttack);
            return attackResult;
        } else {
            System.out.println("Atak sie niepowiodl");
            successAttack = false;
            AttackResult attackResult = new AttackResult(hitPartName, randomObrazenia, numberOfTry, successAttack);
            return attackResult;
        }
    }

    public AttackResult dodge(AttackResult attackResult) {
        System.out.println("Wartosc obrony wynosi: " + this.getDefence());
        if (this.getDefence() > random(1, 10)) {
            System.out.println("Unik sie powiodl");
            attackResult.successAttack = false;
        } else {
            Collection<Armour> listOfAmrours = attackResult.bodyPart.listOfArmours();
            int defenceFromArmour = 0;
            for (Armour armourItem : listOfAmrours) {
                defenceFromArmour = defenceFromArmour + random(armourItem.minDefence(), armourItem.maxDefence());
                System.out.println("Armour " + armourItem + " can give min " + armourItem.minDefence() + " and max " + armourItem.maxDefence() + " additional defence");
            }
            int obrazenia = attackResult.potentialDamage - this.getEndurance() - defenceFromArmour;
            attackResult.finalDamage = obrazenia;
            if (obrazenia > 0) {
                this.lifePoints = this.getLifePoints() - obrazenia;
                if (this.bodyPartHitNumber.get(attackResult.bodyPart) != null) {
                    System.out.println("Aktualna ilosc uderzen w " + attackResult.bodyPart + " wynosi " + this.bodyPartHitNumber.get(attackResult.bodyPart));
                    int x = this.bodyPartHitNumber.get(attackResult.bodyPart);
                    this.bodyPartHitNumber.put(attackResult.bodyPart, attackResult.hitNumber + x);
                } else {
                    bodyPartHitNumber.put(attackResult.bodyPart, 1);
                }
            }
            System.out.println("Faktyczne obrazenia wynosza" + obrazenia);

////////////////////////////dotad dziala zapisywanie w kreaturze mapy trafien.
        }
        if (this.getLifePoints() > 0) {
            return attackResult;
        } else {
            System.out.println("Postac " + this.creatureType + " nie ma juz punktow zycia");
        }
        return attackResult;
    }

    public boolean isAlive() {
        if (this.getLifePoints() > 0)
            return true;
        else
            return false;
    }

    Optional<BodyPart> trafionaCzesc() {
        int randomValue = random(1, 100);
        int wskaznik = 0;
        BodyPart allBodyParts[] = BodyPart.values();
        for (int i = 0; i < allBodyParts.length; i++) {
            BodyPart allBodyPart = allBodyParts[i];
            if (randomValue <= allBodyPart.PrawdopodobienstwoTrafienia() + wskaznik) {
                System.out.println("-----------------------------------Trafiona czest to:" + allBodyPart.toString());

                return Optional.of(allBodyPart);
            } else {
                wskaznik = wskaznik + allBodyPart.PrawdopodobienstwoTrafienia();
            }
        }
        return Optional.empty();
        //throw new RuntimeException("Nie trafino w zadna czesc.");
    }

    int random(int min, int max) {
        return utilitiesMain.random(min, max);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "creatureType='" + creatureType + '\'' +
                " maxpoints " + getTotalValueOfSDDEL() +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", defence=" + defence +
                ", endurance=" + endurance +
                ", lifePoints=" + lifePoints +
                " ilosc wygranych " + numberOfWins +
                " jestem overridem z klasy Creature" +
                '}';
    }
}


//jak wywolac metode random z klasy CreatureFactory - static a najlepiej osobna klse z utilitisami

//kiedy stosujemy throw exception a kiedy Optional ???