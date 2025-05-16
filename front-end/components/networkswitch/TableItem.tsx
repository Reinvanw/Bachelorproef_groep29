import { NetworkSwitch } from "@/types";
import React from "react";

type Props = {
  networkSwitch: NetworkSwitch;
};

const TableItem: React.FC<Props> = ({ networkSwitch }: Props) => {
  return (
    <>
      <td>{networkSwitch.switchID}</td>
      <td>{networkSwitch.hostname}</td>
      <td>{networkSwitch.managementIP}</td>
    </>
  );
};

export default TableItem;