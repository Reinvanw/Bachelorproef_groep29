const getUsers = async () => {
    return await fetch(process.env.NEXT_PUBLIC_API_URL +"/user/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
};

export default {getUsers}