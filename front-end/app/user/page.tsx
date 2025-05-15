"use client";

import { useEffect } from "react";
import useInterval from "use-interval";
import useSWR, { mutate } from "swr";
import { User } from "@/types";
import UserService from "@/services/UserService";
import Table from "@/components/user/Table";

const fetchUsers = async () => {
  const response = await UserService.getUsers();
  const result = await response.json();
  return result;
};
  
const UsersPage: React.FC = () => {
  useEffect(() => {
    mutate('fetchUsers', fetchUsers);
  }, []);

  useInterval(() => {
    mutate("fetchUsers", fetchUsers);
  }, 2000);

  const { data: users, error } = useSWR<Array<User>>("fetchUsers", fetchUsers);

  return (
    <>
      <main>
        <div>
          <h1>User Overview</h1>
              <Table users={users} />
        </div>
      </main>
    </>
  );
}

export default UsersPage;