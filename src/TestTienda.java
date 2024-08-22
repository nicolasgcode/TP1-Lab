import logica.*;
import modelos.*;

public class TestTienda {
    public static void main(String[] args) {

        Carro c = new Carro();

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "fi", 9, 2, 2.3, "plastico", false, "19/8/2024", 100, 5);
        ProductoEnvasado p2 = new ProductoEnvasado("AB124", "ar", 20, 1, 2.3, "plastico", false, "12/13/12", 150, 123);
        // ProductoBebida p2 = new ProductoBebida("AC124", "desc1", 20, 5,
        // 2.3,0,false,0,"");

        Tienda t = new Tienda("fasuShop", 100, 1000);
        // t.getProductos().add(p1);
        // t.getProductos().add(p2);

        System.out.println();
        c.agregarAlCarrito(p2, 15);
        c.agregarAlCarrito(p1, 15);
        System.out.println(t);
        OperacionTienda.Compra(t, c);

        // c.addItemToCart(p1, 12);
        // OperacionTienda.Compra(t);

        // System.out.println(OperacionTienda.getSaleList().toString());

        OperacionTienda.obtenerComestiblesConMenorDescuento(t, 5.9);

        c.agregarAlCarrito(p2, 15);
        c.agregarAlCarrito(p1, 15);

        OperacionTienda.Venta(t, c);

        System.out.println(t);

        // // OperacionTienda.setMiVenta(10, p1);
        // // OperacionTienda.setMiVenta(8, p2);

        // System.out.println(t);

    }

}