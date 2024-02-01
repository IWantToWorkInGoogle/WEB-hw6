package ru.itmo.wp.model.service;

import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.Talk;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.TalkRepository;
import ru.itmo.wp.model.repository.UserRepository;
import ru.itmo.wp.model.repository.impl.TalkRepositoryImpl;
import ru.itmo.wp.model.repository.impl.UserRepositoryImpl;

import java.util.List;

public class TalkService {

    private final TalkRepository talkRepository = new TalkRepositoryImpl();
    private final UserRepository userRepository = new UserRepositoryImpl();

    public void validateMessage(Talk talk,String targetLogin, String text) throws ValidationException {
        if (Strings.isNullOrEmpty(targetLogin)) {
            throw new ValidationException("Target login is required.");
        }
        if (Strings.isNullOrEmpty(text)) {
            throw new ValidationException("Text is required.");
        }
        if (targetLogin.length() < 4) {
            throw  new ValidationException("The login is too short.");
        }
        if (targetLogin.length() > 64) {
            throw new ValidationException("The login is too long.");
        }
        if (text.length() > 255) {
            throw new ValidationException("The text is too long.");
        }
        if (userRepository.findByLogin(targetLogin) == null) {
            throw new ValidationException("The target doesn't exist.");
        }
        if (talk.getSourceUserId() == userRepository.findByLogin(targetLogin).getId()) {
            throw new ValidationException("You can't send a message to yourself.");
        }
    }

    public void sendMessage(Talk talk, String targetLogin, String text) {
        talk.setTargetUserId(userRepository.findByLogin(targetLogin).getId());
        talk.setText(text);
        talkRepository.send(talk);
    }

    public List<Talk> findAll() {
        return talkRepository.findAll();
    }
}
