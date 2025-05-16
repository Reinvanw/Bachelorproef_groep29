import Link from "next/link";
import logo from "../public/images/logo_nobg.png";
import Image from "next/image";
import { useEffect, useState } from "react";


type Props = {};

const Header: React.FC<Props> = ({ }: Props) => {
    return (
        <header className="bg-white shadow-md sticky top-0 z-50">
            <nav className="flex justify-between items-center px-4 py-4">

                <Link href="/">
                    <Image src={logo} alt="Logo" className="ml-5 h-12 w-auto" />
                </Link>

                <div className="flex space-x-15 mr-15 text-gray-800">
                    <Link href="/" className="hover:text-blauw-logo transition-colors duration-200">
                        Home
                    </Link>
                    <Link href="/teams" className="hover:text-blauw-logo transition-colors duration-200">
                        Teams
                    </Link>
                    <Link href="/networkswitch" className="hover:text-blauw-logo transition-colors duration-200">
                        Switches
                    </Link>
                    <Link href="/login" className="hover:text-blauw-logo transition-colors duration-200">
                        Login
                    </Link>
                </div>
            </nav>
        </header>
    );
};

export default Header;
