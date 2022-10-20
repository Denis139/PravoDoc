package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.LandAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LandUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LandView;
import ru.gavrish.pravodoc.service.domain.LandDomainService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;

@RestController
@RequiredArgsConstructor
public class LandController {

    LandDomainService service;

    @PostMapping(value = ADD_LAND_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@Valid @RequestBody LandAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_LAND_DISPUTES)
    public LandView get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping(value = GET_ALL_LAND_DISPUTES)
    public List<LandView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_LAND_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LandView update(@PathVariable UUID id, @Valid @RequestBody LandUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_LAND_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
