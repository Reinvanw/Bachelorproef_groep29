"use client";

import { useEffect } from "react";
import useInterval from "use-interval";
import useSWR, { mutate } from "swr";
import { Team } from "@/types";
import TeamService from "@/services/TeamService";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import TableTeam from "@/components/tableTeamOverview/TableTeam";

const fetchTeams = async () => {
  const response = await TeamService.getTeams();
  const result = await response.json();
  return result;
};

const TeamsPage: React.FC = () => {
  useEffect(() => {
    mutate('fetchTeams', fetchTeams);
  }, []);

  useInterval(() => {
    mutate("fetchTeams", fetchTeams);
  }, 2000);

  const { data: teams, error } = useSWR<Array<Team>>("fetchTeams", fetchTeams);

  return (
    <>
     <Header />
      <main>
       
        <div>
          <h1 className="mt-10 text-2xl font-medium  mx-auto w-[90vw] max-w-6xl">Team Overview</h1>
              <TableTeam teams={teams} />
        </div>
      </main>
      <Footer />
    </>
  );
}

export default TeamsPage;