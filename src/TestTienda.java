import logica.*;

public class TestTienda {
    public static void main(String[] args) {

        Tienda t = new Tienda("Panchito", 10, 0);

        ProductoEnvasado pe = new ProductoEnvasado("AB123", "Fideos", 5, 20, 2.5, true, "Plastico", true);

        System.out.println("El costo total del producto es: " + pe.costoTotal());

        System.out.println("El estado actual de la tienda es: " + t.toString());

        t.realizarCompra(pe, 10);

        System.out.println("El estado actual de la tienda luego de la compra test es: " + t.toString());

    }


}
