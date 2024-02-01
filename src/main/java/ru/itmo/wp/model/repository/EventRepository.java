package ru.itmo.wp.model.repository;

import ru.itmo.wp.model.domain.Event;

import java.util.List;

public interface EventRepository {

    public void save(Event event);

}
