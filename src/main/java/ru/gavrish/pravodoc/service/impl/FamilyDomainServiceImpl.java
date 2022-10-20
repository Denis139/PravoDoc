package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.FamilyMapper;
import ru.gavrish.pravodoc.model.dto.request.FamilyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.FamilyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.FamilyView;
import ru.gavrish.pravodoc.model.entity.FamilyDisputes;
import ru.gavrish.pravodoc.repository.FamilyDisputesRepository;
import ru.gavrish.pravodoc.service.domain.FamilyDomainService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FamilyDomainServiceImpl implements FamilyDomainService {

    FamilyMapper familyMapper;
    FamilyDisputesRepository familyRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(FamilyAddRequest request) {
        var family = familyMapper.from(request);
        family = familyRepository.saveAndFlush(family);
        return family.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public FamilyView get(UUID id) {
        return familyMapper.fromRevers(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FamilyView> getAll() {
        return familyRepository.findAll()
                .stream()
                .map(o->familyMapper.fromRevers(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FamilyView update(UUID id, FamilyUpdateRequest request) {
        var family = findById(id);
        family = familyMapper.merge(family, request);
        familyRepository.saveAndFlush(family);
        return familyMapper.fromRevers(family);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var family = findById(id);
        familyRepository.delete(family);
        familyRepository.flush();
        return !familyRepository.existsById(id);
    }

    FamilyDisputes findById(UUID id) {
        return familyRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("FamilyDisputes with id [%s] not found\", id")));
    }
}
