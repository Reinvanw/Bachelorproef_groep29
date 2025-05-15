import { User } from "@/types";
import Router from "next/router";

const getUsers = async () => {
    return await fetch(process.env.NEXT_PUBLIC_API_URL +"/user/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
    .then(response => response.json()).then(data =>{return data})
};

export default {getUsers}
