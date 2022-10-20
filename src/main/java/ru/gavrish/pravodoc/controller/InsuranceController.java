package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.InsuranceAddRequest;
import ru.gavrish.pravodoc.model.dto.request.InsuranceUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.InsuranceView;
import ru.gavrish.pravodoc.service.domain.InsuranceDomainService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;

@RestController
@RequiredArgsConstructor
public class InsuranceController {

    InsuranceDomainService service;

    @PostMapping(value = ADD_INSYRANCE_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@RequestBody @Valid InsuranceAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_INSYRANCE_DISPUTES)
    public InsuranceView get(@PathVariable UUID id) {
        return get(id);
    }

    @GetMapping(value = GET_ALL_INSYRANCE_DISPUTES)
    public List<InsuranceView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_INSYRANCE_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public InsuranceView update(@PathVariable UUID id, @Valid @RequestBody InsuranceUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_INSYRANCE_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
