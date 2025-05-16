"use client";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Table from "@/components/team/Table";
import { useEffect, useState } from "react";
import teamService from "@/services/TeamService";

const HomePage: React.FC = () => {
  const [teams, setTeams] = useState([]);

  useEffect(() => {
    const fetchTeams = async () => {
      try {
        const response = await teamService.getTeams();
        if (response.ok) {
          const data = await response.json();
          setTeams(data);
        } else {
          console.error("Failed to fetch teams");
        }
      } catch (error) {
        console.error("Error fetching teams:", error);
      }
    };

    fetchTeams();
  }, []);

  return (
    <>
      <Header />
      <main className="flex flex-col">
        <h1 className="mt-30 text-6xl font-medium  mx-auto w-[90vw] max-w-6xl">Overview</h1>
        <Table teams={teams} />
      </main>
      <Footer />
    </>
  );
};

export default HomePage;