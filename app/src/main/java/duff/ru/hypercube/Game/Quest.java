package duff.ru.hypercube.Game;

import java.util.ArrayList;

/**
 * Created by maks on 15.03.18.
 */

public class Quest extends ElementsOfLevel {

    String question;
    String trueAnswer;

    String loserDialog;
    String winsDialog;

    String loserPicture;
    String winsPicture;

    ArrayList<Answer> answer;
    Reward reward;
    String picture;

    public Quest(String question, String trueAnswer, String loserDialog, String winsDialog, ArrayList<Answer> answer, Reward reward, String picture, String loserPicture, String winsPicture) {
        this.question = question;
        this.answer = answer;
        this.reward = reward;
        this.trueAnswer = trueAnswer;
        this.picture = picture;
        this.loserDialog = loserDialog;
        this.winsDialog = winsDialog;
        this.loserPicture = loserPicture;
        this.winsPicture = winsPicture;
    }

    public Quest() {

    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public String getPicture() {
        return picture;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswer() {
        return answer;
    }

    public Reward getReward() {
        return reward;
    }

    public Answer getAnswerById(int id) {
        return answer.get(id);
    }

    public String getLoserPicture() {
        return loserPicture;
    }

    public String getWinsPicture() {
        return winsPicture;
    }

    public String getLoserDialog() {
        return loserDialog;
    }

    public String getWinsDialog() {
        return winsDialog;
    }
}
