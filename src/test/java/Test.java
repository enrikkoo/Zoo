
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;


public class Test {

    User_Tools ut = new User_Tools(new Zoo());

    @BeforeClass
    public static void adding() {
        Add.add();
    }

    @Before
    public void feed() {
        ut.feed(AnimalTypes.HERBIVORE);
        ut.feed(AnimalTypes.CARNIVORE);
    }

    @After
    public void info() {
        Zoo.info();
    }

    @org.junit.Test
    public void test1() {
        ut.visit(AnimalTypes.HERBIVORE);
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test2() {
        ut.visit(AnimalTypes.CARNIVORE);
        for (Animal animal : Zoo.all_animals) {
            if (animal instanceof Herbivore) {
                Assert.assertEquals(Current_Status.CALM, animal.getStatus());
            } else if (animal instanceof Carnivore) {
                Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
            }
        }
    }

    @org.junit.Test
    public void test3() {
        ut.visit(AnimalTypes.HERBIVORE);
        ut.setNight();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test4() {
        ut.setThunder();
        ut.setMorning();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test5() {
        ut.setNight();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.SLEEP, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test6() {
        ut.setThunder();
        ut.setNight();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test7() {
        ut.setNight();
        ut.setMorning();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.CALM, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test8() {
        ut.setThunder();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
        }
    }

    @org.junit.Test
    public void test9() {
        ut.visit(AnimalTypes.CARNIVORE);
        ut.setMorning();
        for (Animal animal : Zoo.all_animals) {
            if (animal instanceof Herbivore) {
                Assert.assertEquals(Current_Status.CALM, animal.getStatus());
            } else if (animal instanceof Carnivore) {
                Assert.assertEquals(Current_Status.NOISE, animal.getStatus());
            }
        }
    }

    @org.junit.Test
    public void test10() {
        ut.setMorning();
        ut.setThunder();
        ut.feed(AnimalTypes.CARNIVORE);
        ut.feed(AnimalTypes.HERBIVORE);
        ut.setNight();
        for (Animal animal : Zoo.all_animals) {
            Assert.assertEquals(Current_Status.SLEEP, animal.getStatus());
        }
    }
}

