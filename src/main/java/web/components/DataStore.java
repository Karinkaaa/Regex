package main.java.web.components;

import org.springframework.stereotype.Component;

@Component
public class DataStore {

    private static ThreadLocal<String> storage = new ThreadLocal() {

        @Override
        protected Object initialValue() {
            return "DEFAULT VALUE";
        }
    };

    public void addDataToStorage(String data) {
        storage.set(data);
    }

    public String getDataFromStorage() {
        return storage.get();
    }
}
