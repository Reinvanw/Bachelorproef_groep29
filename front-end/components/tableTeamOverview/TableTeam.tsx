import TableItem from "./TableTeamItem";
import teamService from "@/services/TeamService";

type Props = {
    teams?: Array<any>;
    onDeleteTeam?: (teamID: number) => void;
};

const Table: React.FC<Props> = ({ teams = [], onDeleteTeam }: Props) => {
    const handleDelete = async (teamID: number) => {
        await teamService.deleteTeam(teamID);
        if (onDeleteTeam) onDeleteTeam(teamID); // Optionally update state in parent
    };

    return (
        <div className="mt-10 verflow-x-auto mx-auto w-[90vw] max-w-6xl">
            <table className="min-w-full bg-white rounded-xl overflow-hidden ">
                <thead>
                    <tr className="border" style={{ borderBottomColor: "var(--blauw-logo)" }}>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">TeamID</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">TeamName</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Add Team Members</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Delete Team</th>
                    </tr>
                </thead>
                <tbody>
                    {teams.map((team, index) => (
                        <tr
                            key={team.teamID}
                            className={`${
                                index % 2 === 0 ? "bg-white" : "bg-gray-100"
                            } hover:bg-gray-100 transition`}
                        >
                            <TableItem team={team} onDelete={handleDelete} />
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Table;