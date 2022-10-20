package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.PropertyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.PropertyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.PropertyView;
import ru.gavrish.pravodoc.service.domain.PropertyDomainService;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;

@RestController
@RequiredArgsConstructor
public class PropertyController {

    PropertyDomainService service;

    @PostMapping(value = ADD_PROPERTY_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@Valid @RequestBody PropertyAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_PROPERTY_DISPUTES)
    public PropertyView get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping(value = GET_ALL_PROPERTY_DISPUTES)
    public List<PropertyView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_PROPERTY_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public PropertyView update(@PathVariable UUID id, @Valid @RequestBody PropertyUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_PROPERTY_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
