package ru.gavrish.pravodoc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gavrish.pravodoc.model.dto.request.FamilyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.FamilyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.FamilyView;
import ru.gavrish.pravodoc.service.domain.FamilyDomainService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.gavrish.pravodoc.util.Constant.*;

@RestController
@RequiredArgsConstructor
public class FamilyController {

    FamilyDomainService service;

    @PostMapping(value = ADD_FAMILY_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UUID add(@Valid @RequestBody FamilyAddRequest request) {
        return service.add(request);
    }

    @GetMapping(value = GET_FAMILY_DISPUTES)
    public FamilyView get(UUID id) {
        return service.get(id);
    }

    @GetMapping(value = GET_ALL_FAMILY_DISPUTES)
    public List<FamilyView> getAll() {
        return service.getAll();
    }

    @PatchMapping(value = UPDATE_FAMILY_DISPUTES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public FamilyView update(@PathVariable UUID id, @Valid @RequestBody FamilyUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = DELETE_FAMILY_DISPUTES)
    public Boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}







