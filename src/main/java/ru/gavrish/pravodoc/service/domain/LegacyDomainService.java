package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.LegacyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LegacyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LegacyView;
import java.util.List;
import java.util.UUID;

public interface LegacyDomainService {

    UUID add(LegacyAddRequest request);

    LegacyView get(UUID id);

    List<LegacyView> getAll();

    LegacyView update(UUID id, LegacyUpdateRequest request);

    Boolean delete(UUID id);
}
