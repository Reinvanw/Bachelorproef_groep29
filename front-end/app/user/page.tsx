'use client';

import { User } from '@/types';
import React, { useState } from 'react';
import UserService from '@/services/UserService';
import useSWR from 'swr';
import UserOverview from '@/components/users/UserOverview';




const Test: React.FC = () => {
    const [users, setUsers] = useState<Array<User>>([]);

    const getUsers = async () => {
        try {
            const fetchedUsers = await UserService.getUsers();
            setUsers(fetchedUsers);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
        return users;
    };

    const {data, error} = useSWR('users', getUsers);

    return (
        <>
            <main>
                {data &&(
                    <section>
                        <UserOverview users={data}/>
                    </section>                   
                )}
            </main>
        </>
    );
};

export default Test;


