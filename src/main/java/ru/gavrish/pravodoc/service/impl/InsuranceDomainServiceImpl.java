package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.InsuranceMapper;
import ru.gavrish.pravodoc.model.dto.request.InsuranceAddRequest;
import ru.gavrish.pravodoc.model.dto.request.InsuranceUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.InsuranceView;
import ru.gavrish.pravodoc.model.entity.InsuranceDisputes;
import ru.gavrish.pravodoc.repository.InsuranceDisputesRepository;
import ru.gavrish.pravodoc.service.domain.InsuranceDomainService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InsuranceDomainServiceImpl implements InsuranceDomainService {

    InsuranceMapper insuranceMapper;
    InsuranceDisputesRepository insuranceRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(InsuranceAddRequest request) {
        var insurance = insuranceMapper.from(request);
        insurance = insuranceRepository.saveAndFlush(insurance);
        return insurance.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public InsuranceView get(UUID id) {
        return insuranceMapper.fromRevers(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<InsuranceView> getAll() {
        return insuranceRepository.findAll()
                .stream()
                .map(o->insuranceMapper.fromRevers(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public InsuranceView update(UUID id, InsuranceUpdateRequest request) {
        var insurance = findById(id);
        insurance = insuranceMapper.merge(insurance, request);
        insuranceRepository.saveAndFlush(insurance);
        return insuranceMapper.fromRevers(insurance);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var insurance = findById(id);
        insuranceRepository.delete(insurance);
        insuranceRepository.flush();
        return !insuranceRepository.existsById(id);
    }

    InsuranceDisputes findById(UUID id) {
        return insuranceRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("InsuranceDisputes with id [%s] not found\", id")));
    }
}
