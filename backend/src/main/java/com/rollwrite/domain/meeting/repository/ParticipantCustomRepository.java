package com.rollwrite.domain.meeting.repository;

import com.rollwrite.domain.meeting.entity.Meeting;
import com.rollwrite.domain.meeting.entity.Participant;
import java.util.List;

public interface ParticipantCustomRepository {

    List<Participant> findParticipantByUser(Long userId);

    List<Meeting> findMeetingByUser(Long userId);

}
