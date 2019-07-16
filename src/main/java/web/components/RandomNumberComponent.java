package main.java.web.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberComponent {

    private final DataStore dataStore;

    @Autowired
    public RandomNumberComponent(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public int getRandom(int seed) {

        System.out.println("Data from DataStore: " + dataStore.getDataFromStorage());
        dataStore.getDataFromStorage();
        return new Random(seed).nextInt();
    }
}
