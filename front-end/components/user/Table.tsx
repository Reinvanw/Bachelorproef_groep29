import TableItem from "./TableItem";

type Props = {
    users?: Array<any>;
};

const Table: React.FC<Props> = ({ users = [] }: Props) => {

    return (
        <table>
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                {users.map((user, index) => (
                    <tr key={index}>
                        <TableItem user={user} />
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default Table;