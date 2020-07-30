package com.example.assu;

public class ModelOfAssignmentsTest {
  private   boolean rideos;
  private   String ques ;

    public ModelOfAssignmentsTest(String ques) {
        this.ques = ques;
    }

    public boolean isRideos() {
        return rideos;
    }

    public void setRideos(boolean rideos) {
        this.rideos = rideos;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }
}
