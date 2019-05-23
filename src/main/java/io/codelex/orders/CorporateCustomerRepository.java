package io.codelex.orders;

import org.springframework.data.jpa.repository.JpaRepository;

interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, String> {
}
