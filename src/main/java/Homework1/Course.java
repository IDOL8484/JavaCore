package Homework1;

import java.util.Arrays;

public class Course {
    boolean random;
    int winCount = 0;
    private Obstacles[] obs = new Obstacles[4];

    public Course() {
        obs[0] = new Obstacles("Sand Pit");
        obs[1] = new Obstacles("Swimming Pool");
        obs[2] = new Obstacles("Barrier");
        obs[3] = new Obstacles("Trampoline");
    }

    public Obstacles[] getObs() {
        return obs;
    }

    public void setObs(Obstacles[] obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Course{" +
                "obs=" + Arrays.toString(obs) +
                '}';
    }

    public void doIt(Team team) {

        for (int i = 0; i < team.member.length; i++) {
            winCount = 0;
            System.out.println("\nУчастник " + team.member[i].getName());

                for (int j = 0; j < obs.length; j++) {
                    System.out.print("   испытание: " + obs[j] + ". ");

                    random = Math.random() < team.member[i].getLuck();
                    if(random) {
                        winCount++;
                        System.out.println("    == " + team.member[i].getName() + " прохошёл " + obs[j] + "! ==" );
                    } else {
                        System.out.println("Испытание не пройдено.");
                    }
            }
                if (winCount == 4) {
                    System.out.println(team.member[i].getName() + " прошел все испытания! Красавчик!!");
                }
                if(winCount < 4 && winCount >= 1) {
                    System.out.println(team.member[i].getName() + " прошел " + winCount + " испытание(ия).");
                }
                if (winCount < 1) {
                System.out.println(team.member[i].getName() + " не смог себя проявить. Результат 0.");
            }
        }
    }
}
