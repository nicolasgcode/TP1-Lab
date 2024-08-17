import logica.*;

public class TestTienda {
    public static void main(String[] args) {

        Tienda t = new Tienda("Shop", 100, 100);

        ProductoEnvasado pe = new ProductoEnvasado("AB123", "Fideos", 3, 20, 2.5, true, "Plastico", true);

        System.out.println(pe);

        System.out.println("El costo total del producto es: " + pe.costoTotal());

        System.out.println("El estado actual de la tienda es: " + t.toString());

        t.realizarCompra(pe, 10);

        System.out.println("El estado de la tienda luego de la compra es: " + t.toString());

    }


}
