"use client";

import { useEffect } from "react";
import useInterval from "use-interval";
import useSWR, { mutate } from "swr";
import { NetworkSwitch } from "@/types";
import NetworkSwitchService from "@/services/NetworkSwitchService";
import Table from "@/components/networkswitch/Table";

const fetchNetworkSwitches = async () => {
  const response = await NetworkSwitchService.getNetworkSwitches();
  const result = await response.json();
  return result;
};

const NetworkSwitchesPage: React.FC = () => {
  useEffect(() => {
    mutate('fetchNetworkSwitches', fetchNetworkSwitches);
  }, []);

  useInterval(() => {
    mutate("fetchNetworkSwitches", fetchNetworkSwitches);
  }, 2000);

  const { data: networkSwitches, error } = useSWR<Array<NetworkSwitch>>("fetchNetworkSwitches", fetchNetworkSwitches);

  return (
    <>
      <main>
        <div>
          <h1>NetworkSwitch Overview</h1>
              <Table networkSwitches={networkSwitches} />
        </div>
      </main>
    </>
  );
}

export default NetworkSwitchesPage;