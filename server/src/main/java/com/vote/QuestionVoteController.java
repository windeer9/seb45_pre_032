package com.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/question_vote")
@Validated
public class QuestionVoteController {
    private VoteService voteService;
    private VoteMapper mapper;


    @PostMapping("/")
    public ResponseEntity postQuestionVote(){

      Vote createdVote = voteService.createdVote();

       return new ResponseEntity(createdVote ,HttpStatus.CREATED);
    }

    @PatchMapping("/{member_id}/{vote_id}")
    public ResponseEntity patchQuestionVote(@PathVariable("member_id") @Positive long memberId,
                                    @PathVariable("vote_id") @Positive long voteId,
                                    @RequestBody VoteDto.Patch vote){
        vote.addVoteId(voteId);
        Vote updatedVote = voteService.updateVote(mapper.votePatchDtoToVote(vote));
        return new ResponseEntity(mapper.voteToVoteResponseDto(updatedVote), HttpStatus.OK);
    }

    @GetMapping("/{vote_id}")
    public ResponseEntity findQuestionVote(@PathVariable("vote_id") @Positive long voteId){
       Vote findVote = voteService.findVoteCount(voteId);

       return new ResponseEntity(mapper.voteToVoteResponseDto(findVote), HttpStatus.OK);
    }



}
