import { Team } from "@/types";
import React from "react";

type Props = {
  team: Team;
  onDelete: (teamID: number) => void;
};

const TableItem: React.FC<Props> = ({ team, onDelete }: Props) => {
  const handleDeleteClick = () => {
    if (window.confirm(`Are you sure you want to delete ${team.teamName}?`) && team.teamID !== undefined) {
      onDelete(team.teamID);
    }
  };

  return (
    <>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamID}</td>
      <td className="text-xs text-gray-500 font-medium p-2 border border-gray-200 text-center">{team.teamName}</td>
      <td className="p-2 border border-gray-200 text-center">
        <button className="cursor-pointer bg-green-400 hover:bg-green-500 text-white text-xs font-medium px-3 py-2 rounded-lg mr-2">
          Add Team Member
        </button>
      </td>
      <td className="p-2 border border-gray-200 text-center">
        <button
          className="cursor-pointer bg-red-400 hover:bg-red-500 text-white text-xs font-medium px-3 py-2 rounded-lg"
          onClick={handleDeleteClick}
        >
          Delete team
        </button>
      </td>
    </>
  );
};

export default TableItem;