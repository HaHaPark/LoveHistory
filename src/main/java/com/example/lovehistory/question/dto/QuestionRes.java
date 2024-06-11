package com.example.lovehistory.question.dto;

public class QuestionRes {

    Long questionId;
    String questionContent;

    public QuestionRes(Long questionId, String questionContent) {
        this.questionId = questionId;
        this.questionContent = questionContent;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
