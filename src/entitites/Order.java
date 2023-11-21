package entitites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private Client client;

    private List <OrderItem> itens = new ArrayList<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    public void addItem(OrderItem item){
        itens.add(item);
    }

    public void removeItem(OrderItem item){
        itens.remove(item);
    }
    public double total(){
        double sum = 0;
        for(OrderItem orderItem: itens){

            sum += orderItem.subTotal();


        }
        return sum;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + sdf.format(moment) + " \n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client + "\n");
        sb.append("Order itens: \n");
        for(OrderItem orderItem: itens){
           sb.append(orderItem.getProduct() + ", $");
           sb.append(orderItem.getPrice() + ", ");
           sb.append("Quantity: " + orderItem.getQuantity() + ", ");
           sb.append("Subtotal: $" + orderItem.subTotal() + "\n");
        }

        sb.append("Total: " + total());
    return sb.toString();
    }

}
