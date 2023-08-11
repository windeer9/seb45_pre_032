package com.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.question.Question;
import com.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "MEMBERS_ID")
    private Member memberId;

    public void addMember(Member member){
        this.memberId = member;
    }

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question questionId;
}
