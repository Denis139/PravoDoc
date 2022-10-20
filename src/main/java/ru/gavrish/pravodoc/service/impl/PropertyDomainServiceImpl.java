package ru.gavrish.pravodoc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrish.pravodoc.mapper.PropertyMapper;
import ru.gavrish.pravodoc.model.dto.request.PropertyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.PropertyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.PropertyView;
import ru.gavrish.pravodoc.model.entity.PropertyDisputes;
import ru.gavrish.pravodoc.repository.PropertyDisputesRepository;
import ru.gavrish.pravodoc.service.domain.PropertyDomainService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PropertyDomainServiceImpl implements PropertyDomainService {

    PropertyMapper propertyMapper;

    PropertyDisputesRepository propertyRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UUID add(PropertyAddRequest request) {
        var property = propertyMapper.from(request);
        propertyRepository.saveAndFlush(property);
        return property.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public PropertyView get(UUID id) {
        return propertyMapper.fromRevers(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PropertyView> getAll() {
        return propertyRepository.findAll()
                .stream()
                .map(o->propertyMapper.fromRevers(o))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PropertyView update(UUID id, PropertyUpdateRequest request) {
        var property = findById(id);
        property = propertyMapper.merge(property, request);
        propertyRepository.saveAndFlush(property);
        return propertyMapper.fromRevers(property);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(UUID id) {
        var property = findById(id);
        propertyRepository.delete(property);
        propertyRepository.flush();
        return !propertyRepository.existsById(id);
    }

    PropertyDisputes findById(UUID id) {
        return propertyRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("PropertyDisputes with id [%s] not found\", id")));

    }
}
