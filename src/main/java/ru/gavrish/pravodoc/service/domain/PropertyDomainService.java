package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.PropertyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.PropertyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.PropertyView;
import java.util.List;
import java.util.UUID;

public interface PropertyDomainService {

    UUID add(PropertyAddRequest request);

    PropertyView get(UUID id);

    List<PropertyView> getAll();

    PropertyView update(UUID id, PropertyUpdateRequest request);

    Boolean delete(UUID id);
}
