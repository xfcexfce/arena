package com.example.arena;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CreatureTest {

    @Test
    public void isAlive() {
        // given
        Creature c1 = new Creature(CreatureType.ELF, 2, 2, 2, 2, 2);

        UtilitiesMain utilitiesMainMock = Mockito.mock(UtilitiesMain.class);
        Mockito.when(utilitiesMainMock.random(Mockito.anyInt(), Mockito.anyInt())).thenReturn(91);


        c1.setUtilitiesMain(utilitiesMainMock);

        // when
        boolean wartosc = c1.isAlive();
        // wartosc = false;

        // then
        Assert.assertTrue("postac powinna byc alive a nie jest", wartosc);
        System.out.println("ttttttt" + wartosc);
    }


    @Test
    public void dodge() {
        //given
        Creature c1 = new Creature(CreatureType.HUMAN, 2, 2, 2, 2, 2);
        AttackResult attackResult = new AttackResult(BodyPart.TRUNK, 3,1,true);

        //UtilitiesMain
        UtilitiesMain utilitiesMainMock = Mockito.mock(UtilitiesMain.class);
        Mockito.when(utilitiesMainMock.random(Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
        c1.setUtilitiesMain(utilitiesMainMock);

        //when
        AttackResult attackResultResult = c1.dodge(attackResult);
        //System.out.println("Czy atak sie powiodl???" + attackResult.successAttack);

        //then
        Assert.assertFalse("Unik powinien byl sie powiesc - ale unik nie wyszedl", attackResult.successAttack);


    }
}