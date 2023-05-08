import { SERVER_URL } from "./../constants/url";
import axios from "axios";

export const axiosInstance = axios.create({
  baseURL: `${SERVER_URL}/api`,
  withCredentials: true,
  headers: {
    "Content-type": "application/json",
  },
});

export const axiosFileInstance = axios.create({
  baseURL: `${SERVER_URL}/api`,
  withCredentials: true,
  headers: {
    "Content-type": "multipart/form-data",
  },
});