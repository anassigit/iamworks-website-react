package com.iamworks.backend.repository;

import com.iamworks.backend.model.ColorOption;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorOptionRepository extends JpaRepository<ColorOption, Long> {
    List<ColorOption> findAllByOrderBySortOrderAsc();
}
