package pinchuk.msscssm.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;
import pinchuk.msscssm.domain.Payment;
import pinchuk.msscssm.domain.PaymentEvent;
import pinchuk.msscssm.domain.PaymentState;
import pinchuk.msscssm.repository.PaymentRepository;

import java.math.BigDecimal;

/**
 * @author Pinchuk Yevhen
 * @created 21/03/2020 - 20:47
 */
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);

        System.out.println("Should be NEW");
        System.out.println(savedPayment.getState());

        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getOne(savedPayment.getId());

        System.out.println("Should be PRE_AUTH");
        System.out.println(sm.getState().getId());

        System.out.println(preAuthedPayment);

    }
}