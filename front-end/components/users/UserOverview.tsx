import React, { useState } from "react";
import { User } from "@/types";


type Props = {
    users: Array<User>;
};


const UsersOverview: React.FC<Props> = ({ users }: Props) => {

        const sortedUsers = users;

     return (
        <> 
            {sortedUsers.map((user) => (
                    <article>
                        <h2>{user.email}</h2>
                        <p>{user.password}</p>
                    </article>
                    
                ))
            }
        </>
    );
};

export default UsersOverview;
