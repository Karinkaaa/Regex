package test.java.web.test;

import main.java.birds.entities.Bird;
import main.java.web.components.BirdStoreComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BirdStoreComponentTest {

    private BirdStoreComponent store;
    private Bird bird;

    @Before
    public void beforeEachTest() {

        store = new BirdStoreComponent();
        bird = new Bird("eagle", "forest", 1.2);
    }

    @Test
    public void addBird() {

        Bird resultBird = store.addBird(bird);
        Assert.assertEquals(bird, resultBird);

        Bird bird2 = store.searchByName(bird.getName());
        Assert.assertEquals(bird, bird2);

        Bird resultBird2 = store.addBird(bird);
        Assert.assertNull(resultBird2);
    }

    @Test
    public void deleteBird() {

        store.addBird(bird);
        Assert.assertEquals(bird, store.deleteBird(bird.getName()));

        Assert.assertNull(store.deleteBird(bird.getName()));
    }

    @Test
    public void updateBird() {

        store.addBird(bird);

        String name = "eagle";
        String newName = "titmouse";

        Bird expectedBird = new Bird(newName, bird.getLivingArea(), bird.getSize());
        Assert.assertEquals(expectedBird, store.updateBird(name, newName));

        Assert.assertEquals(newName, bird.getName());

        Assert.assertNull(store.searchByName(name));

        Assert.assertEquals(expectedBird, store.searchByName(newName));
    }

    @Test
    public void searchByName() {

        store.addBird(bird);

        String name = "eagle";
        Assert.assertEquals(bird, store.searchByName(name));

        name = "titmouse";
        Assert.assertNull(store.searchByName(name));
    }
}
