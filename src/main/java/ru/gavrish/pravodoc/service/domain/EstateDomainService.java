package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.EstateAddRequest;
import ru.gavrish.pravodoc.model.dto.request.EstateUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.EstateView;

import java.util.List;
import java.util.UUID;

public interface EstateDomainService {

    UUID add(EstateAddRequest request);

    EstateView get(UUID id);

    List<EstateView> getAll();

    EstateView update(UUID id, EstateUpdateRequest request);

    Boolean delete(UUID id);
}
