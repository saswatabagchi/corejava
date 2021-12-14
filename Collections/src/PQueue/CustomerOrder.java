package PQueue;

public class CustomerOrder implements Comparable<CustomerOrder> {
    private int orderId;
    private double orderAmount;
    private String customerName;

    public CustomerOrder(int orderId, double orderAmount, String customerName) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.customerName = customerName;
    }

    @Override
    public int compareTo(CustomerOrder o) {
        return o.orderAmount > this.orderAmount ? 1 : -1;
    }

    @Override
    public String toString() {
        return "orderId:" + this.orderId + ", orderAmount:" + this.orderAmount + ", customerName:" + customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
