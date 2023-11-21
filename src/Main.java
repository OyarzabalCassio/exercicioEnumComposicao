import entitites.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParseException {


        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Digite as informações do individuo: ");
        System.out.println("Nome: ");
        String name = sc.next();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Data de nascimento (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name,email, birthDate);
        System.out.println("Status do pedido: ");
        System.out.println("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(),orderStatus, client);
        System.out.println("Quantos itens: ");
        int itensQuantity = sc.nextInt();
        for(int i = 1;i <= itensQuantity; i++){
            System.out.println("Digite o item #" + i);
            System.out.println("Nome: ");
            String productName = sc.next();
            System.out.println("Preço: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantidade: ");
            int productQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
            order.addItem(orderItem);
        }



        System.out.println();
        System.out.println(order);






        sc.close();
        }

}