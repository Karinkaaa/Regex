package main.java.web.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationComponent {

    private final RandomNumberComponent randomComponent;
    private final DataStore dataStore;

    @Autowired
    public OperationComponent(RandomNumberComponent randomComponent, DataStore dataStore) {
        this.randomComponent = randomComponent;
        this.dataStore = dataStore;
    }

    public int add(int a, int b) {

        dataStore.addDataToStorage(a + " " + b);
        return a + b + randomComponent.getRandom(b);
    }
}
