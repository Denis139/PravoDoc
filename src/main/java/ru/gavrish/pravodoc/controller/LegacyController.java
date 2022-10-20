package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.LegacyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LegacyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LegacyView;
import ru.gavrish.pravodoc.service.domain.LegacyDomainService;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;

@RestController
@RequiredArgsConstructor
public class LegacyController {

    LegacyDomainService service;

    @PostMapping(value = ADD_LEGACY_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@Valid @RequestBody LegacyAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_LEGACY_DISPUTES)
    public LegacyView get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping(value = GET_ALL_LEGACY_DISPUTES)
    public List<LegacyView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_LEGACY_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LegacyView update(@PathVariable UUID id, @RequestBody @Valid LegacyUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_LEGACY_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
