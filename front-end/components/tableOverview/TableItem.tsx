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
      <td className="p-2 border border-gray-200 text-center">
        <button className="cursor-pointer bg-red-400 hover:bg-red-500 text-white text-xs font-semibold px-2 py-2 rounded">
          Delete team
        </button>
      </td>
    </>
  );
};

export default TableItem;