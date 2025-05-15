import { NetworkSwitch } from "@/types";
import Router from "next/router";

const getNetworkSwitches = async () => {
    return await fetch(process.env.NEXT_PUBLIC_API_URL +"/networkswitch/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
    .then(response => response.json()).then(data =>{return data})
};

export default {getNetworkSwitches}
