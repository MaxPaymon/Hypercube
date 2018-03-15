package duff.ru.hypercube.Game;

import java.util.ArrayList;

/**
 * Created by maks on 15.03.18.
 */

public class Quest extends ElementsOfLevel {

    int id;
    String question;
    ArrayList<Answer> answer;
    ArrayList<Reward> reward;

    public Quest(int id, String question, ArrayList<Answer> answer, ArrayList<Reward> reward) {
        this.question = question;
        this.answer = answer;
        this.reward = reward;
        this.id = id;
    }

    public Answer getAnswerById(int id) {
        return answer.get(id);
    }

    public int getId() {
        return id;
    }

    public Reward getRewardFromQuest(int answerId) {
        return reward.get(answerId);
    }
}
