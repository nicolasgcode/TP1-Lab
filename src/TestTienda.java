import logica.*;

public class TestTienda {
    public static void main(String[] args) {

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "desc1", 15, 5, 2.5, "plastico", true, "19/8/2024", 123);

        Tienda t = new Tienda("fasuShop", 100, 1000);

        System.out.println(t);

//        OperacionTienda.agregarParaCompra(p1);
//        OperacionTienda.agregarParaCompra(p2);
//        OperacionTienda.agregarParaCompra(p3);

        t.getProductos().add(p1);
        System.out.println(t);
        OperacionTienda.agregarParaVenta(5, p1, t);
        OperacionTienda.agregarParaVenta(12, p1, t);
//          OperacionTienda.agregarParaVenta(10, p1, t);
        OperacionTienda.Venta(t);


        System.out.println(t);

    }


}
