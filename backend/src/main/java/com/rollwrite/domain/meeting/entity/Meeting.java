package com.rollwrite.domain.meeting.entity;

import com.rollwrite.domain.meeting.dto.AddMeetingReqDto;
import com.rollwrite.domain.question.entity.Answer;
import com.rollwrite.domain.question.entity.Question;
import com.rollwrite.domain.question.entity.QuestionGpt;
import com.rollwrite.domain.question.entity.QuestionParticipant;
import com.rollwrite.global.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meeting extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    private String title;

    @Column
    private LocalDate startDay;

    @Column
    private LocalDate endDay;

    @NotNull
    @Column(length = 7)
    private String color;

    @Column(length = 20, unique = true)
    private String inviteCode;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<Participant> participantList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<Award> awardList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<QuestionGpt> questionGptList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<QuestionParticipant> questionParticipantList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<Answer> answerList = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<TagMeeting> tagMeetingList = new ArrayList<>();

    public void updateTagMeetingList(List<TagMeeting> tagMeetingList) {
        this.tagMeetingList = tagMeetingList;
    }

    @Builder
    public Meeting(Long id, AddMeetingReqDto addMeetingReqDto, String inviteCode) {
        this.id = id;
        this.title = addMeetingReqDto.getTitle();
        this.startDay = addMeetingReqDto.getStartDay();
        this.endDay = addMeetingReqDto.getEndDay();
        this.color = addMeetingReqDto.getColor();
        this.inviteCode = inviteCode;
    }
}
