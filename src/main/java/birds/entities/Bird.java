package main.java.birds.entities;

/**
 * Bird.
 * <p>
 * Должны быть следущие свойства:
 * <p>
 * name  тип String
 * livingArea тип String
 * size – число с плавающей точкой, может быть незаполненным (Double).
 */
public class Bird {

    private String name;
    private String livingArea;
    double size;

    public Bird(String name, String livingArea, double size) {

        this.name = name;
        this.livingArea = livingArea;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "\n\nName: " + getName() + "\nLiving area: " + getLivingArea() + "\nSize: " + getSize();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Bird) {

            Bird otherBird = (Bird) obj;
            return this.getName().equals(otherBird.getName()) &&
                    this.getLivingArea().equals(otherBird.getLivingArea()) &&
                    this.getSize() == (otherBird.getSize());
        }
        return false;
    }
}
