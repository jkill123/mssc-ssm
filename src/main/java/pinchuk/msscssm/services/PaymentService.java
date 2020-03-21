package pinchuk.msscssm.services;

import org.springframework.statemachine.StateMachine;
import pinchuk.msscssm.domain.Payment;
import pinchuk.msscssm.domain.PaymentEvent;
import pinchuk.msscssm.domain.PaymentState;

/**
 * @author Pinchuk Yevhen
 * @created 21/03/2020 - 19:27
 */
public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}