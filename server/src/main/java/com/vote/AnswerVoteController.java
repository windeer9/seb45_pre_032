package com.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/answer_vote")
@Validated
public class AnswerVoteController {

    private final VoteService voteService;

    private final VoteMapper mapper;

    public AnswerVoteController(VoteService voteService,
                                VoteMapper mapper){
        this.voteService = voteService;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public ResponseEntity postAnswerVote(){
       Vote createdVote = voteService.createdVote();

       return new ResponseEntity(createdVote, HttpStatus.CREATED);
    }

    @PatchMapping("/{member_id}/{vote_id}")
    public ResponseEntity patchAnswerVote(@PathVariable("member_id") @Positive long memberId,
                                          @PathVariable("vote_id") @Positive long voteId,
                                          @RequestBody VoteDto.Patch patch){
        patch.addVoteId(voteId);
        Vote updateVote = voteService.updateVote(mapper.votePatchDtoToVote(patch));

        return new ResponseEntity(mapper.voteToVoteResponseDto(updateVote), HttpStatus.OK);
    }

    @GetMapping("/{vote_id}")
    public ResponseEntity findAnswerVote(@PathVariable("vote_id") @Positive long voteId){
        Vote findVote = voteService.findVoteCount(voteId);

        return new ResponseEntity(mapper.voteToVoteResponseDto(findVote), HttpStatus.OK);
    }

}
