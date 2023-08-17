package com.vote;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteId;
    private String voteType;
    private long voteCount;

    private long memberId;

//    @OneToOne
//    private Question question;
//
//    @OneToOne
//    private Answer answer;
}