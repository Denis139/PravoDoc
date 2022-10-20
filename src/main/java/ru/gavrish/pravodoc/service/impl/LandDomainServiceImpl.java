package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.LandMapper;
import ru.gavrish.pravodoc.model.dto.request.LandAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LandUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LandView;
import ru.gavrish.pravodoc.model.entity.LandDisputes;
import ru.gavrish.pravodoc.repository.LandDisputesRepository;
import ru.gavrish.pravodoc.service.domain.LandDomainService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LandDomainServiceImpl implements LandDomainService {

    LandDisputesRepository landRepository;
    LandMapper landMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(LandAddRequest request) {
        var land = landMapper.from(request);
        land = landRepository.saveAndFlush(land);
        return land.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public LandView get(UUID id) {
        return landMapper.fromRevers(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LandView> getAll() {
        return landRepository.findAll()
                .stream()
                .map(o -> landMapper.fromRevers(o))
                .toList();

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LandView update(UUID id, LandUpdateRequest request) {
        var land = findById(id);
        land = landMapper.merge(land, request);
        landRepository.saveAndFlush(land);
        return landMapper.fromRevers(land);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var land = findById(id);
        landRepository.delete(land);
        landRepository.flush();
        return !landRepository.existsById(id);
    }

    LandDisputes findById(UUID id) {
        return landRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("LandDisputes with id [%s] not found\", id")));
    }
}