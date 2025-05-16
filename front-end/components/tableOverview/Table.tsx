import TableItem from "./TableItem";

type Props = {
    teams?: Array<any>;
};

const Table: React.FC<Props> = ({ teams = [] }: Props) => {
    return (
        <div className="mt-10 overflow-x-auto mx-auto w-[90vw] max-w-6xl">
            <table className="min-w-full bg-white rounded-xl overflow-hidden ">
                <thead>
                    <tr
                        className="border"
                        style={{ borderBottomColor: "var(--blauw-logo)" }}
                    >
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">TeamID</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Team Name</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Switch name</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Switch IP</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Status</th>
                        <th className="px-6 py-3 text-xs font-semibold text-white bg-blauw-logo border border-gray-200 text-center">Reset Switch</th>
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
                            <TableItem team={team} />
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Table;