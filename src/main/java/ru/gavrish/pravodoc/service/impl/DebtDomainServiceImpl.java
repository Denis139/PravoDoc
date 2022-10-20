package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.DebtMapper;
import ru.gavrish.pravodoc.model.dto.request.DebtAddRequest;
import ru.gavrish.pravodoc.model.dto.request.DebtUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.DebtView;
import ru.gavrish.pravodoc.model.entity.DebtDisputes;
import ru.gavrish.pravodoc.repository.DebtDisputesRepository;
import ru.gavrish.pravodoc.service.domain.DebtDomainService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DebtDomainServiceImpl implements DebtDomainService {

    DebtDisputesRepository debtRepository;
    DebtMapper debtMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(DebtAddRequest request) {
        var debt = debtMapper.from(request);
        debt = debtRepository.saveAndFlush(debt);
        return debt.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public DebtView get(UUID id) {
        return debtMapper.fromRevers(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DebtView> getAll() {
        return debtRepository.findAll()
                .stream()
                .map(o->debtMapper.fromRevers(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DebtView update(UUID id, DebtUpdateRequest request) {
        var debt = findById(id);
        debt = debtMapper.merge(debt, request);
        debtRepository.saveAndFlush(debt);
        return debtMapper.fromRevers(debt);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var debt = findById(id);
        debtRepository.delete(debt);
        debtRepository.flush();
        return !debtRepository.existsById(id);
    }

    public DebtDisputes findById(UUID id) {
        return debtRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("DebtDisputes with id [%s] not found", id)));

    }
}
