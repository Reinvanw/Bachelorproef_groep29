import TableItem from "./TableItem";

type Props = {
    networkSwitches?: Array<any>;
};

const Table: React.FC<Props> = ({ networkSwitches = [] }: Props) => {

    return (
        <table>
            <thead>
                <tr>
                    <th>SwitchID</th>
                    <th>Switch name</th>
                    <th>Switch ip</th>
                </tr>
            </thead>
            <tbody>
                {networkSwitches.map((networkSwitch, index) => (
                    <tr key={index}>
                        <TableItem networkSwitch={networkSwitch} />
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

export default Table;