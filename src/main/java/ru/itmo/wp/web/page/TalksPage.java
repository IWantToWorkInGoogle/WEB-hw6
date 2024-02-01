package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Talk;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.TalkService;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TalksPage extends Page{
    private final TalkService talkService = new TalkService();

    private final UserService userService = new UserService();

    public void action(HttpServletRequest request, Map<String, Object> view) {
        if (request.getSession().getAttribute("user") == null) {
            throw new RedirectException("/index");
        } else {
            view.put("messages",talkService.findAll());
            view.put("users",userService.findAll());
        }
    }

    private void sendMessage(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        if (request.getSession().getAttribute("user") != null) {
            Talk talk = new Talk();
            talk.setSourceUserId(((User) request.getSession().getAttribute("user")).getId());
            String targetLogin = request.getParameter("targetLogin");
            String text = request.getParameter("text");
            view.put("messages", talkService.findAll());
            view.put("users", userService.findAll());
            talkService.validateMessage(talk, targetLogin, text);
            talkService.sendMessage(talk, targetLogin, text);
            request.getSession().setAttribute("message", "You have sent the message successfully!");
        }
        throw new RedirectException("/index");
    }
}
