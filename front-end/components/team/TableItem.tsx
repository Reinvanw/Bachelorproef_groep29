import { Team } from "@/types";
import React from "react";

type Props = {
  team: Team;
};

const TableItem: React.FC<Props> = ({ team }: Props) => {
  return (
    <>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamID}</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamName}</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamName}</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamName}</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamName}</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamName}</td>
    </>
  );
};

export default TableItem;