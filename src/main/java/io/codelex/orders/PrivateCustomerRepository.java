package io.codelex.orders;

import org.springframework.data.jpa.repository.JpaRepository;

interface PrivateCustomerRepository extends JpaRepository<PrivateCustomer, String> {
}
