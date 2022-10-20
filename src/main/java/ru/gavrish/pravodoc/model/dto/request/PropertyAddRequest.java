package ru.gavrish.pravodoc.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.PropertyEnum;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class PropertyAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @javax.validation.constraints.NotNull(message = "Field [variety] mustn't be null")
    private PropertyEnum variety;

    @javax.validation.constraints.NotNull(message = "Field [price] mustn't be null")
    private BigDecimal price;
}
