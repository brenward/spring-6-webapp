package com.bwardweb.spring6webapp.repositories;

import com.bwardweb.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
