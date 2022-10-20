package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.LegacyMapper;
import ru.gavrish.pravodoc.model.dto.request.LegacyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LegacyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LegacyView;
import ru.gavrish.pravodoc.model.entity.LegacyDisputes;
import ru.gavrish.pravodoc.repository.LegacyDisputesRepository;
import ru.gavrish.pravodoc.service.domain.LegacyDomainService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LegacyDomainServiceImpl implements LegacyDomainService {

    LegacyMapper legacyMapper;

    LegacyDisputesRepository legacyRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(LegacyAddRequest request) {
        var legacy = legacyMapper.from(request);
        legacyRepository.saveAndFlush(legacy);
        return legacy.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public LegacyView get(UUID id) {
        return legacyMapper.fromRevers(findById(id));

    }

    @Override
    @Transactional(readOnly = true)
    public List<LegacyView> getAll() {
        return legacyRepository.findAll()
                .stream()
                .map(o->legacyMapper.fromRevers(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LegacyView update(UUID id, LegacyUpdateRequest request) {
        var legacy = findById(id);
        legacy = legacyMapper.merge(legacy, request);
        legacyRepository.saveAndFlush(legacy);
        return legacyMapper.fromRevers(legacy);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var legacy = findById(id);
        legacyRepository.delete(legacy);
        legacyRepository.flush();
        return !legacyRepository.existsById(id);
    }

    LegacyDisputes findById(UUID id) {
        return legacyRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("LegacyDisputes with id [%s] not found\", id")));
    }
}
