package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.DebtAddRequest;
import ru.gavrish.pravodoc.model.dto.request.DebtUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.DebtView;
import ru.gavrish.pravodoc.service.domain.DebtDomainService;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;


@RestController
@RequiredArgsConstructor
class DebtController {

    DebtDomainService service;

    @PostMapping(value = ADD_DEBT_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@Valid @RequestBody DebtAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_DEBT_DISPUTES)
    public DebtView get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping(value = GET_ALL_DEBT_DISPUTES)
    public List<DebtView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_DEBT_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public DebtView update(@RequestBody @Valid UUID id, DebtUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_DEBT_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
