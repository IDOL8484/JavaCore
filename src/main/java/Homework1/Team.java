package Homework1;

import java.util.Arrays;

public class Team {
    private String teamName;
    Members[] member = new Members[4];

    public Team() {
        teamName = "Beavers";
        member[0] = new Members("Phillip", 0.3);
        member[1] = new Members("Serge", 0.8);
        member[2] = new Members("Denis", 0.51);
        member[3] = new Members("Michael", 0.63);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Members[] getMember() {
        return member;
    }

    public void setMember(Members[] member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Команда:" + teamName +
                ", и ёе участники:\n" + Arrays.toString(member);
    }
}
