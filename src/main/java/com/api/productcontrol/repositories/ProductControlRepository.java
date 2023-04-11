package com.api.productcontrol.repositories;

import com.api.productcontrol.models.ProductControlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProductControlRepository extends JpaRepository<ProductControlModel, UUID> {


}
