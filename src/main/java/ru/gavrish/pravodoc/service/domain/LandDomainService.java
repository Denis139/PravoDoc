package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.LandAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LandUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LandView;
import java.util.List;
import java.util.UUID;

public interface LandDomainService {

    UUID add(LandAddRequest request);

    LandView get(UUID id);

    List<LandView> getAll();

    LandView update(UUID id, LandUpdateRequest request);

    Boolean delete(UUID id);
}
