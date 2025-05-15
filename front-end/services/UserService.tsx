import { User } from "@/types";
import Router from "next/router";

const getUsers = async () => {
  const response = await fetch(process.env.NEXT_PUBLIC_BACKEND_API_URL + "/user/all", {
    method: 'Get',
    headers: {
      'Content-Type': 'application/json',
    }
  });
  return response;
}
