import { User } from "@/types";
import React from "react";

type Props = {
  user: User;
};

const TableItem: React.FC<Props> = ({ user }: Props) => {
  return (
    <>
      <td>{user.email}</td>
      <td>{user.password}</td>
      <td>{user.role}</td>
    </>
  );
};

export default TableItem;