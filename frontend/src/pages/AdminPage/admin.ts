import { axiosInstance } from "../../apis/instance";

export const getUser = async (userType: string) => {
  const response = await axiosInstance.get(`/admin/user/${userType}`);
  return response.data;
};

export const userTypeChange = async (userId: string) => {
  const response = await axiosInstance.put(`/admin/type/${userId}`);
  return response.data;
};
