import AuthService from "@/services/AuthService";
import React, { useState } from "react";
import { useRouter } from "next/navigation";
import { StatusMessage } from "@/types/index";

const Login: React.FC = () => {
    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const [statusMessage, setStatusMessage] = useState<StatusMessage>();
    const [emailError, setEmailError] = useState<string>("");
    const [passwordError, setPasswordError] = useState<string>("");

    const router = useRouter();

    const handleLogin = async (event: React.ChangeEvent<HTMLFormElement>) => {
        event.preventDefault();
        if (!validation()) return;
        
        try {
            const response = await AuthService.login({ email: email.toLowerCase(), password });
            const data = await response.json();

            if (response.ok) {
                sessionStorage.setItem("token", JSON.stringify(data.token));
                sessionStorage.setItem("id", JSON.stringify(data.id));
                router.push("/team");
            }
        } catch (error) {
            setStatusMessage({
                type: "error",
                message: ("Error during login"),
            });
        }
    };

    const validation = (): boolean => {
        setEmailError("");
        setPasswordError("");
        if (!email || email.trim() === "", !email.includes("@")) {
            setEmailError(("Email is not valid"));
            return false;
        }
        if (!password || password.trim() === "") {
            setPasswordError(("Password is not valid"));
            return false;
        }
        return true;
    };

    return (
        <div >
            <h2>LOGIN</h2>
            <form onSubmit={handleLogin}>
                {statusMessage && <p>{statusMessage.message}</p>}
                <input
                    type="text"
                    name="email"
                    onChange={(input) => setEmail(input.target.value)}
                    placeholder={"Email"}
                />
                {emailError && <span>{emailError}</span>}
                <input
                    type="password"
                    name="password"
                    onChange={(input) => setPassword(input.target.value)}
                    placeholder={"Password"}
                />
                {passwordError && <span>{passwordError}</span>}
                <button type="submit">LOGIN</button>
            </form>
        </div>
    );
};

export default Login;
