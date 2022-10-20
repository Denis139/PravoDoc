package ru.gavrish.pravodoc.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.InsuranceEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class InsuranceUpdateRequest {

    private UUID id;

    private String name;

    private InsuranceEnum variety;

    private BigDecimal price;
}
