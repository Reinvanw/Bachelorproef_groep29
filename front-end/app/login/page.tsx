"use client";

import Login from "@/components/auth/Login";
import Footer from "@/components/Footer";
import Header from "@/components/Header";

const LoginPage: React.FC = () => {
    return (
        <>
        <Header/>
            <main>
                <div>
                    <Login />
                </div>
            </main>
        <Footer/>
        </>
    );
};

export default LoginPage;
