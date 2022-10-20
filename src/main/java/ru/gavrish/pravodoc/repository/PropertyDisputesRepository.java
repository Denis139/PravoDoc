package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.PropertyDisputes;
import java.util.UUID;

public interface PropertyDisputesRepository extends JpaRepository<PropertyDisputes, UUID> {
}
