package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.EstateAddRequest;
import ru.gavrish.pravodoc.model.dto.request.EstateUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.EstateView;
import ru.gavrish.pravodoc.service.domain.EstateDomainService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;

@RestController
@RequiredArgsConstructor
public class EstateController {

    EstateDomainService service;

    @PostMapping(value = ADD_ESTATE_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@Valid @RequestBody EstateAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_ESTATE_DISPUTES)
    public EstateView get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping(value = GET_ALL_ESTATE_DISPUTES)
    public List<EstateView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_ESTATE_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public EstateView update(@PathVariable UUID id, @Valid @RequestBody EstateUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_ESTATE_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
