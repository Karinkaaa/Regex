package main.java.web.components;

import main.java.birds.entities.Bird;
import main.java.birds.abstract_store.AbstractBirdStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */

@Component
public class BirdStoreComponent extends AbstractBirdStore {

    private Map<String, Bird> mapStorage = new HashMap<>();

    public BirdStoreComponent() {
    }

    @Override
    public Bird addBird(Bird bird) {

        if (!mapStorage.containsKey(bird.getName())) {
            mapStorage.put(bird.getName(), bird);
            return bird;
        }
        return null;
    }

    @Override
    public Bird deleteBird(String name) {
        return mapStorage.remove(name);
    }

    @Override
    public Bird updateBird(String name, String newName) {

        Bird bird = mapStorage.get(name);
        if (bird != null) {
            bird.setName(newName);
            mapStorage.remove(name);
            mapStorage.put(newName, bird);
        }
        return bird;
    }

    @Override
    public Bird searchByName(String nameToSearch) {

        if (mapStorage.containsKey(nameToSearch))
            return mapStorage.get(nameToSearch);
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {

        List<Bird> listBirds = new ArrayList<>();

        for (Map.Entry<String, Bird> entry : mapStorage.entrySet()) {
            if (entry.getValue().getLivingArea().equals(livingAreaToFind))
                listBirds.add(entry.getValue());
        }
        return listBirds;
    }
}