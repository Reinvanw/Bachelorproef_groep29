import { Login } from "@/types/index";

const baseUrl = process.env.NEXT_PUBLIC_BACKEND_API_URL;

const login = ({ email, password }: Login) => {
    const data = {
        email: email,
        password: password,
    };

    return fetch(baseUrl + "/auth/authenticate", {
        method: "POST",
        headers: {
            "Content-Type": "Application/json",
        },
        body: JSON.stringify(data),
    });
};

const LoginService = {
    login,
};

export default LoginService;