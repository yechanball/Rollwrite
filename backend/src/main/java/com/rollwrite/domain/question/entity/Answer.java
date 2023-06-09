package com.rollwrite.domain.question.entity;

import com.rollwrite.domain.meeting.entity.Meeting;
import com.rollwrite.domain.user.entity.User;
import com.rollwrite.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 400)
    private String content;

    @Column(length = 2083)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public void updateImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    @Builder
    public Answer(String content, String imageUrl, User user, Meeting meeting, Question question) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
        this.meeting = meeting;
        this.question = question;
    }
}