package com.kwon.ucf.detail;

public class DetailData {
    //얘도 확인차
    public int personalRating;
    public String comment;
    public String date;
    public String myScore;
    public String myReview;
    //일단 확인차
    public int img;

    public DetailData(int personalRating, String comment, String date, String myScore, String myReview, int img) {
        this.personalRating = personalRating;
        this.comment = comment;
        this.date = date;
        this.myScore = myScore;
        this.myReview = myReview;
        this.img = img;
    }
}
