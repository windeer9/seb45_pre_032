package com.member.Controller;

import com.member.DTO.MemberDto;
import com.member.Entity.Member;
import com.member.Service.MemberService;
import com.member.Mapper.MemberMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/members")
public class MemberController {
//    private final static String MEMBER_DEFAULT_URL ="";
    private MemberService memberService;
    private MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper){
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post postDto){

//        Member member = mapper.memberPostDtotoMember(postDto);    JPA 학습 이전
//        Member createMember = memberService.createMember(member); JPA 학습 이전 / 8월 13일 개발

        Member createMember = memberService.createMember(mapper.memberPostDtotoMember(postDto));

        return new ResponseEntity<>(mapper.memberResponseDtotoMember(createMember), HttpStatus.CREATED);
    }

    @PatchMapping("/{member_id}")
    public ResponseEntity patchMember(@PathVariable("member_id") long memberId,
                                      @Valid @RequestBody MemberDto.Patch patchDto){

//        Member member = mapper.memberPatchDtotoMember(patchDto);  JPA 학습 이전
//        Member updateMember = memberService.updateMember(member); JPA 학습 이전 /8월 13일 개발

        Member updateMember = memberService.updateMember(mapper.memberPatchDtotoMember(patchDto));

        return new ResponseEntity<>(mapper.memberResponseDtotoMember(updateMember), HttpStatus.OK);
    }

    @GetMapping("/{member_id}")
    public ResponseEntity getMember(@PathVariable("member_id") long memberId) {

        Member member = memberService.findMember(memberId); // 데이터

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMember(@PathVariable("member_id") long memberId){

        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
