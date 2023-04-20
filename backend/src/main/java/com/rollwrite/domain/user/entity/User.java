package com.rollwrite.domain.user.entity;

import com.rollwrite.domain.meeting.entity.Participant;
import com.rollwrite.domain.meeting.entity.Statistics;
import com.rollwrite.domain.notification.entity.Notification;
import com.rollwrite.domain.question.entity.Answer;
import com.rollwrite.domain.question.entity.QuestionGpt;
import com.rollwrite.domain.question.entity.QuestionParticipant;
import com.rollwrite.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 200)
    private String identifier;

    @NotNull
    @Column(length = 15)
    private String nickname;

    @NotNull
    @Column(length = 2083)
    private String profileImage;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Participant> participantList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Statistics> statisticsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QuestionParticipant> questionParticipantList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Answer> answerList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notificationiList = new ArrayList<>();

}