package ru.gavrish.pravodoc.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.LegacyEnum;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class LegacyAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @NotNull(message = "Field [variety] mustn't be null")
    private LegacyEnum variety;

    @NotNull(message = "Field [price] mustn't be null")
    private BigDecimal price;
}
