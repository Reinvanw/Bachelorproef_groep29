const getTeams = async () => {
    return await fetch(process.env.NEXT_PUBLIC_API_URL +"/team/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
};

export default {getTeams}
