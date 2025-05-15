import React, { useState } from "react";
import { Team } from "@/types";


type Props = {
    teams: Array<Team>;
};


const TeamsOverview: React.FC<Props> = ({ teams }: Props) => {
     return (
        <> 
            {teams.map((team, index) => (
                    <article key={index}>
                        <h2>{team.teamName}</h2>
                    </article>
                    
                ))
            }
        </>
    );
};

export default TeamsOverview;
