package com.comment;

import lombok.Getter;

public enum ExceptionCode {
    VOTE_NOT_FOUND(404, "Vote Not Found"),
    COMMENT_NOT_FOUND(404, "Comment Not Found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
