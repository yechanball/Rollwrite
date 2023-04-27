import { useDispatch, useSelector } from "react-redux";
import type { TypedUseSelectorHook } from "react-redux";
import type { RootState, AppDispatch } from "../store/store";

export const useAppDispatch: () => AppDispatch = useDispatch;
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;

export interface CreateGroup {
  title: string;
  tag: number[];
  startDay: string;
  endDay: string;
  color: string;
}
export interface Tag {
  tagId: number;
  content: string;
}
export interface Participant {
  profileImage: string;
  userId: number;
}
export interface GroupInfo {
  meetingId: number;
  title: string;
  tag: Tag[];
  startDay: string;
  endDay: string;
  color: string;
  participant: Participant[];
  participantCnt: number;
  questionLimit: number;
  questionUsage: number;
}

export interface Question {
  day: string;
  question: string;
}

export interface DayInfo {
  currentDay: Date;
  formattedDate: string;
  isToday: boolean;
  isCurrMonth: boolean;
  sprout: number;
  question: string;
}

export interface Profile {
  nickname: string;
  profileImg: string;
  ongoingGroupCnt: number;
  completeGroupCnt: number;
}

export interface QuestionInfo {
  meetingId: number;
  title: string;
  day: number;
  questionId: number;
  question: string;
  emoji: string;
  answer: string;
  image: string;
}

export interface AnswerInfo {
  answer: string;
  meetingId: number;
  questionId: number;
  image?: string;
}