package main.java.web.components;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */

public class SingleBirdStore extends BirdStoreComponent {

    private static SingleBirdStore instance;

    private SingleBirdStore() {
    }

    public static SingleBirdStore getInstance() {
        return instance == null ? instance = new SingleBirdStore() : instance;
    }
}