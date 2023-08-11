package com.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

// API요청을 받고 처리하는 컨트롤러, POST/PATCH/DELETE 요청을 처리한다.
@RestController
@RequestMapping("/question_comment")
@Validated
public class QuestionCommentController {
    private final static String QUESTION_COMMENT_URL = "/question_comment";
    private final CommentService commentService;
    private final CommentMapper mapper;

    public QuestionCommentController(CommentService commentService,
                                     CommentMapper mapper){
        this.commentService = commentService;
        this.mapper = mapper;
    }


    @PostMapping("/")
    public ResponseEntity postQuestionComment(@Valid @RequestBody CommentDto.Post post){

        Comment createdComment = commentService.createComment(mapper.commentPostDtoToComment(post));
        return new ResponseEntity(mapper.commentToCommentResponseDto(createdComment), HttpStatus.CREATED);
    }

    @PatchMapping("/{members_id}/{comment_id}")
    public ResponseEntity patchQuestionComment(@PathVariable("members_id") @Positive long memberId,
                                               @PathVariable("comment_id") @Positive long commentId,
                                               @Valid @RequestBody CommentDto.Patch patch){
        // member 검증 로직 필요(Member쪽 로직 가져다쓸겁니다.)
        patch.addCommentId(commentId);
        Comment updateComment = commentService.updateComment(mapper.commentPatchDtoToComment(patch));

        return ResponseEntity.ok(mapper.commentToCommentResponseDto(updateComment));
    }

    @DeleteMapping("/{members_id}/{comment_id}")
    public String deleteQuestionComment(@PathVariable("member_id") @Positive long membersId,
                                      @PathVariable("comment_id") @Positive long commentId){
        // member 검증 로직 필요(Member쪽 로직 가져다쓸겁니다.)
        commentService.deleteComment(commentId);
        return "Commnet Delete successfully";
    }

}
