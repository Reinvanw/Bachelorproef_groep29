"use client";

import { useEffect } from "react";
import useInterval from "use-interval";
import useSWR, { mutate } from "swr";
import { Team } from "@/types";
import TeamService from "@/services/TeamService";
import Table from "@/components/team/Table";

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
      <main>
        <div>
          <h1>Team Overview</h1>
              <Table teams={teams} />
        </div>
      </main>
    </>
  );
}

export default TeamsPage;