package ru.gavrish.pravodoc.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.EstateEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class EstateUpdateRequest {

    private UUID id;

    private String name;

    private EstateEnum variety;

    private BigDecimal price;
}

