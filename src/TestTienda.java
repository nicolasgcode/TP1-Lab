import logica.*;

public class TestTienda {
    public static void main(String[] args) {

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "desc1", 10, 5, 2.3, "plastico", true, "19/8/2024", 123);
        ProductoEnvasado p2 = new ProductoEnvasado("AB124", "desc1", 20, 5, 2.3, "plastico", true, "19/8/2024", 123);

        Tienda t = new Tienda("fasuShop", 100, 1000);

        System.out.println(t);

        OperacionTienda.agregarParaCompra(p1);
        OperacionTienda.agregarParaCompra(p2);
        OperacionTienda.realizarCompra(t);

//        OperacionTienda.setMiVenta(10, p1);
//        OperacionTienda.setMiVenta(8, p2);
//        OperacionTienda.realizarVenta();

        System.out.println(t);

    }


}
