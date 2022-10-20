package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.FamilyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.FamilyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.FamilyView;
import java.util.List;
import java.util.UUID;

public interface FamilyDomainService {

    UUID add(FamilyAddRequest request);

    FamilyView get(UUID id);

    List<FamilyView> getAll();

    FamilyView update(UUID id, FamilyUpdateRequest request);

    Boolean delete(UUID id);
}
