package com.vote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class VoteDto {

    @Getter
    @AllArgsConstructor
    public static class Post{
        private String voteType;
        private long voteCount;
    }
    @Getter
    public static class Patch{
        private long voteId;
        private String voteType;
        private long voteCount;
    }

    @Getter
    @Builder
    public static class Response{
        private long voteId;
        private long memberId;
        private String voteType;
        private long voteCount;
    }


}
