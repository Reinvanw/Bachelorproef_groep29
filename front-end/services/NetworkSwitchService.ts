const getNetworkSwitches = async () => {
    return await fetch(process.env.NEXT_PUBLIC_API_URL +"/networkswitch/all", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
};

export default {getNetworkSwitches}