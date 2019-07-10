package main.java.web.birds.processor;

import main.java.web.birds.entities.Bird;
import main.java.web.components.BirdStoreComponent;

import java.util.List;
import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */

public class UserCommandProcessor implements IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor {

    private BirdStoreComponent birdStore = BirdStoreComponent.getInstance();

    @Override
    public Bird createBird(Scanner userInputReader) {

        String name = createName(userInputReader);
        String livingArea = createLivingArea(userInputReader);
        System.out.print("Please, enter bird size: ");
        double birdSize = userInputReader.nextDouble();
        return new Bird(name, livingArea, birdSize);
    }

    @Override
    public void processInLoop() {

        while (true) {
            System.out.println("\n\nPlease, enter command:\n" +
                    "a - add new Bird\n" +
                    "s - search bird by name\n" +
                    "l - search bird by living area\n" +
                    "exit - terminate application");

            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            processUserCommand(command, in);
        }
    }

    @Override
    public void processUserCommand(String command, Scanner userInputReader) {

        Bird bird;
        switch (command) {
            case "a":
                bird = createBird(userInputReader);
                birdStore.addBird(bird);
                break;
            case "s":
                bird = birdStore.searchByName(createName(userInputReader));
                if (bird != null)
                    System.out.println(bird);
                break;
            case "l":
                String livingArea = createLivingArea(userInputReader);
                List listBirds = birdStore.searchByLivingArea(livingArea);
                showListOfBirds(listBirds);
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Unknown command!");
        }
    }

    private void showListOfBirds(List<Bird> list) {
        for (Bird bird : list)
            System.out.println(bird);
    }

    private String createName(Scanner in) {

        System.out.print("Please, enter bird name: ");
        String name = in.nextLine();
        return name;
    }

    private String createLivingArea(Scanner in) {

        System.out.print("Please, enter bird living area: ");
        String livingArea = in.nextLine();
        return livingArea;
    }
}
