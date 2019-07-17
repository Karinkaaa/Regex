package test.java.web.test;

import main.java.birds.entities.Bird;
import main.java.birds.my_exceptions.DeletingNonexistentObjectException;
import main.java.birds.my_exceptions.ExistingIdException;
import main.java.birds.my_exceptions.InvalidDataException;
import main.java.web.components.BirdStoreComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BirdStoreComponentTest {

    private BirdStoreComponent store;
    private Bird bird;
    private Bird invalidBird;

    @Before
    public void beforeEachTest() {

        store = new BirdStoreComponent();
        bird = new Bird("eagle", "forest", 1.2);
        invalidBird = new Bird("123", "livingArea", 1);
    }

    @Test
    public void addBird() throws ExistingIdException, InvalidDataException {

        Bird resultBird = store.addBird(bird);
        Assert.assertEquals(bird, resultBird);

        Bird bird2 = store.searchByName(bird.getName());
        Assert.assertEquals(bird, bird2);
    }

    @Test(expected = ExistingIdException.class)
    public void addBirdExistingIdException() throws ExistingIdException, InvalidDataException {

        store.addBird(bird);
        store.addBird(bird);
    }

    @Test(expected = InvalidDataException.class)
    public void addBirdInvalidDataException() throws ExistingIdException, InvalidDataException {

        store.addBird(invalidBird);
    }

    @Test
    public void deleteBird() throws ExistingIdException, DeletingNonexistentObjectException, InvalidDataException {

        store.addBird(bird);
        Assert.assertEquals(bird, store.deleteBird(bird.getName()));
    }

    @Test(expected = DeletingNonexistentObjectException.class)
    public void deleteBirdDeletingNonexistentObjectException()
            throws ExistingIdException, DeletingNonexistentObjectException, InvalidDataException {

        store.deleteBird(bird.getName());
    }

    @Test
    public void updateBird() throws ExistingIdException, InvalidDataException {

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
    public void searchByName() throws ExistingIdException, InvalidDataException {

        store.addBird(bird);

        String name = "eagle";
        Assert.assertEquals(bird, store.searchByName(name));

        name = "titmouse";
        Assert.assertNull(store.searchByName(name));
    }

    @Test
    public void searchByLivingArea() throws InvalidDataException, ExistingIdException {

        store.addBird(bird);
        List<Bird> expected = new ArrayList<>();
        expected.add(bird);

        String livingArea = "forest";
        Assert.assertEquals(expected, store.searchByLivingArea(livingArea));

        livingArea = "river";
        Assert.assertEquals(Collections.emptyList(), store.searchByLivingArea(livingArea));
    }
}
