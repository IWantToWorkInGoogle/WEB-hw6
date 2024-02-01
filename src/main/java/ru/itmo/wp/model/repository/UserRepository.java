package ru.itmo.wp.model.repository;

import ru.itmo.wp.model.domain.User;

import java.util.List;

public interface UserRepository {
    User findByEmail(String email);

    User findByLogin(String login);

    User findByLoginOrEmailAndPasswordSha(String loginOrEmail, String passwordSha);

    long findCount();

    void saveUser(User user, String passwordSha);
}
