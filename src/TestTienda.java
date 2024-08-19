import logica.*;

public class TestTienda {
    public static void main(String[] args) {

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "desc1", 10, 5, 2.3, "plastico", true, "19/8/2024", 123);

        Tienda t = new Tienda("fasuShop", 100, 50);

        System.out.println(t);

        OperacionesTienda.realizarCompra(t, p1);

        System.out.println(t);

    }


}
