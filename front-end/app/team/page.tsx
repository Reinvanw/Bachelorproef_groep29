'use client';

import React, { useState } from 'react';
import TeamService from '@/services/TeamService';
import useSWR from 'swr';
import TeamOverview from '@/components/team/TeamOverview';
import { Team } from '@/types';

const Teams: React.FC = () => {
    const [teams, setTeams] = useState<Array<Team>>([]);

    const getTeams = async () => {
        try {
            const fetchedTeams = await TeamService.getTeams();
            setTeams(fetchedTeams);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
        return teams;
    };

    const {data, error} = useSWR('products', getTeams);

    return (
        <>
            <main>
                {data &&(
                    <section>
                        <TeamOverview teams={data}/>
                    </section>                   
                )}
            </main>
        </>
    );
};

export default Teams;


