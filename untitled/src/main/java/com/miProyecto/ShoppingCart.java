package com.miProyecto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout() {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        if (paymentStrategy != null) {
            String message = "Pagando " + total + " utilizando " + paymentStrategy.getClass().getSimpleName() + ".";
            JOptionPane.showMessageDialog(null, message);
            paymentStrategy.pay(total);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha establecido una estrategia de pago.");
        }
    }
}
