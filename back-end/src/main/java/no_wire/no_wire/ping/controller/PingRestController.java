package no_wire.no_wire.ping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no_wire.no_wire.ping.model.Ping;
import no_wire.no_wire.ping.service.PingService;

@RestController
@RequestMapping("/api/network")
public class PingRestController {

    @Autowired
    private PingService pingService;

    @GetMapping("/ping")
    public Ping ping(@RequestParam String ip) {
        return pingService.ping(ip);
    }
}
