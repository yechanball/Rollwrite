package com.rollwrite.domain.question.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AddAnswerRequestDto {
    private final Long meetingId;
    private final Long questionId;
    private final String answer;
}