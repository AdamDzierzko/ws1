package pl.coderslab;

public class status {

    private int orders_id;
    private String status;

    public status() {};

    public status(int orders_id, String status) {
        this.orders_id = orders_id;
        this.status = status;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
