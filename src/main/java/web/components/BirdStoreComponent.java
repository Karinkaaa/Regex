package main.java.web.components;

import main.java.birds.entities.Bird;
import main.java.birds.abstract_store.AbstractBirdStore;
import main.java.birds.my_exceptions.DeletingNonexistentObjectException;
import main.java.birds.my_exceptions.ExistingIdException;
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
    public Bird addBird(Bird bird) throws ExistingIdException {

        if (!mapStorage.containsKey(bird.getName())) {
            mapStorage.put(bird.getName(), bird);
            return bird;
        }
        throw new ExistingIdException("Bird with key <" + bird.getName() + "> already is exists!");
    }

    @Override
    public Bird deleteBird(String name) throws DeletingNonexistentObjectException {

        if (mapStorage.containsKey(name)) {
            return mapStorage.remove(name);
        }
        throw new DeletingNonexistentObjectException("Deletion of a non-existent object is impossible!");
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