package test.java.web.test;

import main.java.web.birds.entities.Bird;
import main.java.web.components.BirdStoreComponent;
import org.junit.Test;

public class BirdControllerTest {

    @Test
    public void addBird() {

        BirdStoreComponent birdStore = BirdStoreComponent.getInstance();
        Bird expectedAddResult = null;
        Bird bird = new Bird("bird", "forest", 1.2);
        Bird addResult = birdStore.addBird(bird);

    }
}
