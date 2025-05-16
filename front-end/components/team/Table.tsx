import TableItem from "./TableItem";

type Props = {
    teams?: Array<any>;
};

const Table: React.FC<Props> = ({ teams = [] }: Props) => {
    return (
        <div className="mt-10 verflow-x-auto mx-auto w-[90vw] max-w-6xl">
            <table className="min-w-full bg-white rounded-xl overflow-hidden ">
                <thead>
                    <tr className="border-b border-gray-200 bg-gray-100 text-gray-600 text-xs font-semibold tracking-wider">
                        <th className="px-6 py-3 text-xs font-semibold text-gray-700 bg-gray-100 border border-gray-200 text-center">TeamID</th>
                        <th className="px-6 py-3 text-xs font-semibold text-gray-700 bg-gray-100 border border-gray-200 text-center">TeamName</th>
                        <th className="px-6 py-3 text-xs font-semibold text-gray-700 bg-gray-100 border border-gray-200 text-center">Switch name</th>
                        <th className="px-6 py-3 text-xs font-semibold text-gray-700 bg-gray-100 border border-gray-200 text-center">Switch IP</th>
                        <th className="px-6 py-3 text-xs font-semibold text-gray-700 bg-gray-100 border border-gray-200 text-center">Status</th>
                        <th className="px-6 py-3 text-xs font-semibold text-gray-700 bg-gray-100 border border-gray-200 text-center">Reset</th>
                    </tr>
                </thead>
                <tbody>
                    {teams.map((team, index) => (
                        <tr
                            key={index}
                            className=" border-gray-200  hover:bg-gray-50 transition text-center"
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