package com.company.TuCarbures.Repositories;

import com.company.TuCarbures.Classes.Fuel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends CrudRepository<Fuel, String> {
}
