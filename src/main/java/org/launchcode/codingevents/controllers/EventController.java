package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
//        model.addAttribute("events", events);
//        return "events/index";

        Map<String, String> events = new HashMap<>();
        events.put("Code With Pride", "LGBT-friendly Coding Event");
        events.put("Strange Loop", "Loops That Are Strange");
        events.put("Apple WWDC", "Event for people who like overpriced computers");
        model.addAttribute("events", events);
        return "events/index";
    }

}