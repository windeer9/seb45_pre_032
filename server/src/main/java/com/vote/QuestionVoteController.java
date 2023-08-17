package com.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/question_vote")
@Validated
public class QuestionVoteController {
    private VoteService voteService;
    private VoteMapper mapper;


    @PostMapping("/")
    public ResponseEntity postVote(){

       voteService.createdVote();

       return ResponseEntity( ,HttpStatus.CREATED);;
    }


}
