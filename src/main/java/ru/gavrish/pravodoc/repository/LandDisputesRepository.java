package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.LandDisputes;

import java.util.UUID;

public interface LandDisputesRepository extends JpaRepository<LandDisputes, UUID> {
}
