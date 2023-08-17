package com.vote;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T15:13:44+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8 (Azul Systems, Inc.)"
)
public class VoteMapperImpl implements VoteMapper {

    @Override
    public Vote votePostDtoToVote(VoteDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Vote vote = new Vote();

        vote.setVoteType( requestBody.getVoteType() );
        vote.setVoteCount( requestBody.getVoteCount() );

        return vote;
    }

    @Override
    public Vote votePatchDtoToVote(VoteDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Vote vote = new Vote();

        vote.setVoteId( requestBody.getVoteId() );
        vote.setVoteType( requestBody.getVoteType() );
        vote.setVoteCount( requestBody.getVoteCount() );

        return vote;
    }

    @Override
    public VoteDto.Response voteToVoteResponseDto(Vote vote) {
        if ( vote == null ) {
            return null;
        }

        VoteDto.Response.ResponseBuilder response = VoteDto.Response.builder();

        response.voteId( vote.getVoteId() );
        response.memberId( vote.getMemberId() );
        response.voteType( vote.getVoteType() );
        response.voteCount( vote.getVoteCount() );

        return response.build();
    }
}
