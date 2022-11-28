package com.itsaboulder.wingedhussar.repositories;

import com.itsaboulder.wingedhussar.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    void deleteInvoiceEntityById(Long id);
}
