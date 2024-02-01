package ru.itmo.wp.web.page;

import ru.itmo.wp.model.service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class EventsPage {
    private final EventService eventService = new EventService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        view.put("events",eventService.findAll());
    }
}
