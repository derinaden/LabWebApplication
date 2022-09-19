package com.ozguryazilim.labwebapplication.repository;

import com.ozguryazilim.labwebapplication.entity.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant,Long> {
}
