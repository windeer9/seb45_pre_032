package com.vote;

import com.comment.Comment;
import com.comment.CommentDto;
import org.mapstruct.Mapper;

@Mapper
public interface VoteMapper{
    Vote votePostDtoToVote(VoteDto.Post requestBody);
    Vote votePatchDtoToVote(VoteDto.Patch requestBody);
    VoteDto.Response voteToVoteResponseDto(Vote vote);
}
