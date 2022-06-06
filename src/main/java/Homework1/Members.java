package Homework1;

public class Members {
    private String name;
    private double luck;

    public Members(String name, double luck) {

        this.name = name;
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    @Override
    public String toString() {
        return name  +
                " с параметром удачи: " + luck;
    }
}
