package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.EstateMapper;
import ru.gavrish.pravodoc.model.dto.request.EstateAddRequest;
import ru.gavrish.pravodoc.model.dto.request.EstateUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.EstateView;
import ru.gavrish.pravodoc.model.entity.EstateDisputes;
import ru.gavrish.pravodoc.repository.EstateDisputesRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EstateDomainService implements ru.gavrish.pravodoc.service.domain.EstateDomainService {

    EstateMapper estateMapper;
    EstateDisputesRepository estateRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(EstateAddRequest request) {
        var estate = estateMapper.from(request);
        estate = estateRepository.saveAndFlush(estate);
        return estate.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public EstateView get(UUID id) {
        return estateMapper.fromRevers(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstateView> getAll() {
        return estateRepository.findAll()
                .stream()
                .map(o->estateMapper.fromRevers(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EstateView update(UUID id, EstateUpdateRequest request) {
        var estate = findById(id);
        estate = estateMapper.merge(estate, request);
        estateRepository.saveAndFlush(estate);
        return estateMapper.fromRevers(estate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var estate = findById(id);
        estateRepository.delete(estate);
        estateRepository.flush();
        return !estateRepository.existsById(id);
    }

    EstateDisputes findById(UUID id) {
        return estateRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("EstateDisputes with id [%s] not found", id)));
    }
}
