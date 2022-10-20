package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.EstateDisputes;
import java.util.UUID;

public interface EstateDisputesRepository extends JpaRepository<EstateDisputes, UUID> {
}
