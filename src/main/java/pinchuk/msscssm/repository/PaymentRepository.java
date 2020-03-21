package pinchuk.msscssm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pinchuk.msscssm.domain.Payment;

/**
 * @author Pinchuk Yevhen
 * @created 21/03/2020 - 17:58
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
