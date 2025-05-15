import React, { useState } from "react";
import { NetworkSwitch } from "@/types";


type Props = {
    networkSwitches: Array<NetworkSwitch>;
};


const NetworkSwitchOverview: React.FC<Props> = ({ networkSwitches }: Props) => {
     return (
        <> 
            {networkSwitches.map((networkSwitch, index) => (
                    <article key={index}>
                        <h2>{networkSwitch.hostname}</h2>
                        <p>{networkSwitch.managementIP}</p>
                        <p>{networkSwitch.userName}</p>
                        <p>{networkSwitch.password}</p>
                    </article>
                    
                ))
            }
        </>
    );
};

export default NetworkSwitchOverview;
