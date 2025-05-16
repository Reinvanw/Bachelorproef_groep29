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
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">Switch 1234</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">192.0.2.1</td>
      <td className="text-xs font-medium p-2 border border-gray-200 text-center">
        <span className="inline-block bg-green-100 text-green-700 border border-green-200 rounded-lg px-3 py-1">
          Online
        </span>
      </td>    
      <td className="p-2 border border-gray-200 text-center">
        <button className="cursor-pointer bg-red-400 hover:bg-red-500 text-white text-xs font-medium px-4 py-2 rounded-lg">
          Reset
        </button>
      </td>
    </>
  );
};

export default TableItem;