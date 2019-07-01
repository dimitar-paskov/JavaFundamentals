package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class DummyTests {

    @Test
    public void dummyLosesHealthIfAttacked(){
//        Axe axe = new Axe(5,10);
        Dummy dummy  = new Dummy(10,10);

        dummy.takeAttack(5);

        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){

        Dummy dummy  = new Dummy(-5,10);

        dummy.takeAttack(3);



    }


    @Test
    public void deadDummyCanGiveXP(){


        Dummy dummy  = new Dummy(-5,10);



        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDDummyCantGiveXP(){


        Dummy dummy  = new Dummy(11,10);



        Assert.assertEquals(0, dummy.giveExperience());
    }
}
