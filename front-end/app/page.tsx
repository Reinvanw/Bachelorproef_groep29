"use client";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
// Update the import path below if the Table component is located elsewhere
import { useEffect, useState } from "react";
import teamService from "@/services/TeamService";
import Table from "@/components/tableOverview/Table";

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
        <h1 className="mt-10 text-2xl font-medium  mx-auto w-[90vw] max-w-6xl">Overview</h1>
        <Table teams={teams} />
      </main>
      <Footer />
    </>
  );
};

export default HomePage;