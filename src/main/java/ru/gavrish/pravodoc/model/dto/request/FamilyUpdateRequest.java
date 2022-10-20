package ru.gavrish.pravodoc.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.FamilyEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class FamilyUpdateRequest {

    private UUID id;

    private String name;

    private FamilyEnum variety;

    private BigDecimal price;
}

