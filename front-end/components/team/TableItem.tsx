import { Team } from "@/types";
import React from "react";

type Props = {
  team: Team;
};

const TableItem: React.FC<Props> = ({ team }: Props) => {
  return (
    <>
      <td>{team.teamID}</td>
      <td>{team.teamName}</td>
    </>
  );
};

export default TableItem;