package chatper10;

import chatper10.model.Order;
import chatper10.model.OrderLine;
import chatper10.service.OrderProcessStep;

import java.math.BigDecimal;
import java.util.Arrays;

import static chatper10.model.Order.OrderStatus.*;

public class ChainofResponisiblityPattern {

    public static void main(String[] args) {
        OrderProcessStep initializeStep = new OrderProcessStep(order -> {
            if(order.getStatus() == CREATED) {
                System.out.println("Start processing order " + order.getId());
                order.setStatus(IN_PROGRESS);
            }
        });

        OrderProcessStep setOrderAmountStep = new OrderProcessStep(order -> {
            if (order.getStatus() == IN_PROGRESS) {
                System.out.println("Setting amount of order " + order.getId());
                order.setAmount(order.getOrderLines().stream()
                        .map(OrderLine::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        });

        OrderProcessStep verifyOrderStep = new OrderProcessStep(order -> {
            if (order.getStatus() == IN_PROGRESS) {
                System.out.println("Verifying order " + order.getId());
                if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                    order.setStatus(ERROR);
                }
            }
        });

        OrderProcessStep processPaymentStep = new OrderProcessStep(order -> {
            if (order.getStatus() == IN_PROGRESS) {
                System.out.println("Processing payment of order " + order.getId());
                order.setStatus(PROCESSED);
            }
        });

        OrderProcessStep handleErrorStep = new OrderProcessStep(order -> {
            if (order.getStatus() == ERROR) {
                System.out.println("Sending out 'Failed to process order' alert for order " + order.getId());
            }
        });

        OrderProcessStep completeProcessingOrderStep = new OrderProcessStep(order -> {
            if(order.getStatus() == PROCESSED) {
                System.out.println("Finished processing order " + order.getId());
            }
        });


        OrderProcessStep chinedOrderProcessStep = initializeStep
                .setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(processPaymentStep)
                .setNext(handleErrorStep)
                .setNext(completeProcessingOrderStep);

        Order order = new Order()
                .setId(1001L)
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        chinedOrderProcessStep.process(order);

        Order failingOrder = new Order()
                .setId(1002L)
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(-2000))));
        chinedOrderProcessStep.process(failingOrder);



    }
}
