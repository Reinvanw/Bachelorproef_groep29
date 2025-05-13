package no_wire.no_wire.ping.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import no_wire.no_wire.ping.model.Ping;

@Service
public class PingService {

    public Ping ping(String ipAddress) {
        StringBuilder output = new StringBuilder();
        boolean reachable = false;

        try {
            ProcessBuilder builder = new ProcessBuilder("ping", "-c", "4", ipAddress);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
                if (line.contains("ttl=")) {
                    reachable = true;
                }
            }

            process.waitFor();

        } catch (Exception e) {
            output.append("Error: ").append(e.getMessage());
        }

        return new Ping(ipAddress, reachable, output.toString());
    }
}
