package main.java.web.controller;

import main.java.birds.entities.Bird;
import main.java.web.components.BirdStoreComponent;
import main.java.web.components.SingleBirdStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("store")
public class BirdController {

    private Logger logger = LoggerFactory.getLogger(BirdController.class);
    private final BirdStoreComponent birdStore = SingleBirdStore.getInstance();

    @RequestMapping(value = "add-bird", method = RequestMethod.PUT)
    @ResponseBody
    public String addBird(String name, String livingArea, double size) {

        Bird bird = new Bird(name, livingArea, size);
        birdStore.addBird(bird);
        logger.info("Adding bird...\n");
        return bird.toString();
    }

    @RequestMapping(value = "delete-bird", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBird(String name) {

        Bird bird = birdStore.deleteBird(name);
        logger.info("Deleting bird...\n");

        if (bird != null)
            return bird.toString();

        return "Bird with name <" + name + "> not found!";
    }

    @RequestMapping(value = "update-bird", method = RequestMethod.POST)
    @ResponseBody
    public String updateBird(String name, String newName) {

        Bird bird = birdStore.updateBird(name, newName);
        logger.info("Updating bird...\n");

        if (bird != null)
            return bird.toString();

        return "Bird with name <" + name + "> not found!";
    }

    @RequestMapping(value = "find-bird", method = RequestMethod.GET)
    @ResponseBody
    public String findBird(String name) {

        Bird bird = birdStore.searchByName(name);
        logger.info("Finding bird...\n");

        if (bird != null)
            return bird.toString();

        return "Bird with name <" + name + "> not found!";
    }
}
