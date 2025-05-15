'use client';

import React, { useState } from 'react';
import useSWR from 'swr';
import { NetworkSwitch, Team } from '@/types';
import NetworkSwitchOverview from '@/components/networkswitch/NetworkswitchOverview';
import NetworkSwitchService from '@/services/NetworkSwitchService';

const NetworkSwitches: React.FC = () => {
    const [networkSwitches, setNetworkSwitches] = useState<Array<NetworkSwitch>>([]);

    const getNetworkSwitches = async () => {
        try {
            const fetchedNetworkSwitches = await NetworkSwitchService.getNetworkSwitches();
            setNetworkSwitches(fetchedNetworkSwitches);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
        return networkSwitches;
    };

    const {data, error} = useSWR('products', getNetworkSwitches);

    return (
        <>
            <main>
                {data &&(
                    <section>
                        <NetworkSwitchOverview networkSwitches={data}/>
                    </section>                   
                )}
            </main>
        </>
    );
};

export default NetworkSwitches;


