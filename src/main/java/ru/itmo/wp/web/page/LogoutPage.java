package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Event;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.domain.status;
import ru.itmo.wp.model.service.EventService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings({"unused"})
public class LogoutPage {
    private final EventService eventService = new EventService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        if (request.getSession().getAttribute("user") != null) {
            Event event = new Event();
            event.setUserId(((User) request.getSession().getAttribute("user")).getId());
            event.setType(status.LOGOUT);
            eventService.save(event);
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("message", "Good bye. Hope to see you soon!");
        }
        throw new RedirectException("/index");
    }
}
