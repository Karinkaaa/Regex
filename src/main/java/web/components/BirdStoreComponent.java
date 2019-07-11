package main.java.web.components;

import main.java.web.birds.entities.Bird;
import main.java.web.birds.store.AbstractBirdStore;
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

    private static BirdStoreComponent instance;
    private Map<String, Bird> mapStorage = new HashMap<>();

    private BirdStoreComponent() {
    }

    public static BirdStoreComponent getInstance() {
        return instance == null ? new BirdStoreComponent() : instance;
    }

    @Override
    public void addBird(Bird bird) {

        if (mapStorage.containsKey(bird.getName()))
            System.out.println("Bird with name " + bird.getName() + " already exists!");
        else
            mapStorage.put(bird.getName(), bird);
    }

    @Override
    public void deleteBird(String name) {
        if (mapStorage.get(name) != null)
            mapStorage.remove(name);
    }

    @Override
    public void updateBird(String name, String newName) {
        Bird bird = mapStorage.get(name);
        bird.setName(newName);
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