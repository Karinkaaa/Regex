package main.java.web.controller;

import main.java.web.birds.entities.Bird;
import main.java.web.components.BirdStoreComponent;
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

    private BirdStoreComponent birdStore = BirdStoreComponent.getInstance();

    @RequestMapping(value = "add-bird", method = RequestMethod.PUT)
    @ResponseBody
    public void addBird(String name, String livingArea, double size) {
        logger.info("name: " + name + "\nlivingArea: " + livingArea + "\nsize: " + size + "\n");
        birdStore.addBird(new Bird(name, livingArea, size));
    }

}
