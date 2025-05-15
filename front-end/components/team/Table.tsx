import TableItem from "./TableItem";

type Props = {
    teams?: Array<any>;
};

const Table: React.FC<Props> = ({ teams = [] }: Props) => {

    return (
        <table>
            <thead>
                <tr>
                    <th>TeamID</th>
                    <th>TeamName</th>
                    <th>Switch name</th>
                    <th>Switch ip</th>
                    <th>Status</th>
                    <th>Reset</th>
                </tr>
            </thead>
            <tbody>
                {teams.map((team, index) => (
                    <tr key={index}>
                        <TableItem team={team} />
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default Table;