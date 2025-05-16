import Link from "next/link";
import { FaFacebook, FaInstagram, FaLinkedin, FaRegCopyright } from 'react-icons/fa';
import logo from "../public/images/logo_nobg.png";
import Image from "next/image";

type Props = {};

const Footer: React.FC<Props> = ({}: Props) => {
    return (
        <footer className="bg-white shadow-top mt-60">
            <div className="flex flex-col md:flex-row justify-center items-start gap-32 py-8">
                <div className="flex flex-col items-center mb-6 md:mb-0">
                    <h2 className="text-xl font-medium mb-4">Quick Links</h2>
                    <div className="flex flex-col space-y-2 items-center">
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
                </div>

                <div className="hidden md:flex flex-col items-center mx-8">
                    <Image src={logo} alt="Logo" className="h-12 w-auto" />
                </div>

                <div className="flex flex-col items-center">
                    <h2 className="text-xl font-medium mb-4">Socials</h2>
                    <div className="flex text-2xl text-gray-600 space-x-4 ">
                        <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer" className="hover:text-blauw-logo transition-colors duration-200">
                            <FaFacebook />
                        </a>
                        <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer" className="hover:text-blauw-logo transition-colors duration-200">
                            <FaInstagram />
                        </a>
                        <a href="https://www.linkedin.com" target="_blank" rel="noopener noreferrer" className="hover:text-blauw-logo transition-colors duration-200">
                            <FaLinkedin />
                        </a>
                    </div>
                </div>
            </div>
            <div className="flex justify-center items-center py-4 text-gray-500 text-sm">
                <span className="flex items-center gap-1 bg-gray-100 px-3 py-1 rounded">
                    LabLink all rights reserved
                    <span className="mx-1"><FaRegCopyright /></span>2025
                </span>
            </div>
        </footer>
    );
};

export default Footer;