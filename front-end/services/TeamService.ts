import { Team } from "@/types";
import Router from "next/router";

const getTeams = async () => {
    return await fetch(process.env.NEXT_PUBLIC_API_URL +"/team/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
    .then(response => response.json()).then(data =>{return data})
};

export default {getTeams}
