import React from "react";
import { AwardPageContainer, AwardPageContent, AwardPageHeader } from "./style";
import { useNavigate, useParams } from "react-router-dom";
import { Award } from "../../../constants/types";
import Btn from "../../Atom/Btn/Btn";
import { ProfileImg } from "../ProfileInfo/style";
interface Props {
  award: Award;
}

function AwardEnd({ award }: Props) {
  const { meetingId } = useParams();
  const navigate = useNavigate();

  return (
    <AwardPageContainer>
      <AwardPageHeader>명예의 전당 🏆</AwardPageHeader>
      이야기 보따리 📚
      <AwardPageContent>
        {award.taleteller.map((profile, i) => {
          return <ProfileImg size={80} bgImg={profile.profileImage} key={i} />;
        })}
      </AwardPageContent>
      포토 그래퍼 📷
      <AwardPageContent>
        {award.photographer.map((profile, i) => {
          return <ProfileImg size={80} bgImg={profile.profileImage} key={i} />;
        })}
      </AwardPageContent>
      프로 개근러 👍
      <AwardPageContent>
        {award.perfectAttendance.map((profile, i) => {
          return <ProfileImg size={80} bgImg={profile.profileImage} key={i} />;
        })}
      </AwardPageContent>
      <Btn
        label="결과 보러가기"
        onClick={() => {
          navigate(`/result/${meetingId}`);
        }}
      ></Btn>
    </AwardPageContainer>
  );
}

export default AwardEnd;
