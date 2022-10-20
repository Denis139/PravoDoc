package ru.gavrish.pravodoc.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.PropertyEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class PropertyUpdateRequest {

    private UUID id;

    private String name;

    private PropertyEnum variety;

    private BigDecimal price;
}
