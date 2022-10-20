package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.PropertyMapper;
import ru.gavrish.pravodoc.model.dto.request.PropertyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.PropertyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.PropertyView;
import ru.gavrish.pravodoc.model.entity.PropertyDisputes;

public class PropertyMapperImpl implements PropertyMapper {

    @Override
    public PropertyDisputes from(PropertyAddRequest source) {
        return new PropertyDisputes()
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public PropertyView fromRevers(PropertyDisputes source) {
        return new PropertyView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public PropertyDisputes merge(PropertyDisputes target, PropertyUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariety(source.getVariety() == null? target.getVariety() : source.getVariety())
                .setPrice(source.getPrice() == null ? target.getPrice() : source.getPrice());
    }
}
