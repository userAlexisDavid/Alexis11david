package com.miProyecto;



public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Agregar artículos al carrito
        cart.addItem(new Item("Libro", 15));
        cart.addItem(new Item("Bolígrafo", 2));

        // Usando tarjeta de crédito
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout();

        // Usando PayPal
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout();

        // Usando transferencia bancaria
        cart.setPaymentStrategy(new BankTransferPayment());
        cart.checkout();
    }
}
