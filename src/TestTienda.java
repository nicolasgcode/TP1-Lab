import logica.*;

public class TestTienda {
    public static void main(String[] args) {

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "desc1", 15, 5, 2.5, "plastico", true, "19/8/2024", 123);
        ProductoEnvasado p2 = new ProductoEnvasado("AB124", "desc1", 20, 5, 2.3, "plastico", true, "19/8/2024", 123);
        ProductoBebida p3 = new ProductoBebida("AC111", "Coca", 10, 5.7, 2, 0, false, 100, "today");

        Tienda t = new Tienda("fasuShop", 100, 1000);

        System.out.println(t);

        OperacionTienda.agregarParaCompra(p1);
        OperacionTienda.agregarParaCompra(p2);
        OperacionTienda.agregarParaCompra(p3);
        OperacionTienda.realizarCompra(t);
        System.out.println(t);
        OperacionTienda.agregarParaVenta(13, p1, t);
//          OperacionTienda.agregarParaVenta(10, p1, t);
        OperacionTienda.realizarVenta(t);


        System.out.println(t);

    }


}
