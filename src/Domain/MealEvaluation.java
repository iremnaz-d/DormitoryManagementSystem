package Domain;

import java.time.LocalDate;

public class MealEvaluation {

    private LocalDate menuDate;
    private int score; //bunun 0-5 arası olması lazım sınırlamayı sonra yaparım belki
    private String comment;

    public MealEvaluation(LocalDate menuDate, int score, String comment) {
        this.menuDate = menuDate;
        this.score = score;
        this.comment = comment;
    }

    public String getRatingDetails(){
        return "ğ";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getMenuDate() {
        return menuDate;
    }


}
