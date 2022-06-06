package Homework1;

public class Obstacles {
    private String obstacleName;

    public Obstacles(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    @Override
    public String toString() {
        return obstacleName;
    }
}
