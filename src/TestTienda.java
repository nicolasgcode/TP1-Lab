import logica.*;
import modelos.*;

public class TestTienda {
    public static void main(String[] args) {

        Carro c = new Carro();

        ProductoEnvasado p1 = new ProductoEnvasado("AB123", "fi", 9, 2, 2.3, "plastico", false, "19/8/2024", 100, 5);
        ProductoEnvasado p2 = new ProductoEnvasado("AB124", "ar", 20, 1, 2.3, "plastico", false, "12/13/12", 150, 123);
        ProductoEnvasado p3 = new ProductoEnvasado("AB126", "fi", 9, 2, 2.3, "plastico", false, "19/8/2024", 100, 5);
        ProductoEnvasado p4 = new ProductoEnvasado("AB127", "ar", 20, 1, 2.3, "plastico", false, "12/13/12", 150, 123);


        //CU: Compra exitosa --
//        Tienda t = new Tienda("GenericShop", 100, 1000);
//        c.agregarAlCarrito(p1, 15);
//        c.agregarAlCarrito(p2, 15);
//        c.agregarAlCarrito(p3, 15);
//        c.agregarAlCarrito(p4, 15);
//        System.out.println(t);
//        OperacionTienda.Compra(t, c);

        //CU: Intento de compra con saldo insuficiente --
//        Tienda t = new Tienda("GenericShop", 100, 10);
//        c.agregarAlCarrito(p2, 15);
//        c.agregarAlCarrito(p1, 15);
//        System.out.println(t);
//        OperacionTienda.Compra(t, c);

        //CU: Intento de compra cuando se ha alcanzado el stock máximo --
//        Tienda t = new Tienda("GenericShop", 5, 1000);
//        c.agregarAlCarrito(p2, 15);
//        System.out.println(t);
//        OperacionTienda.Compra(t, c);
//        System.out.println(t);


//---------------------------------------------------------------------------------------------------------

        //CU: Venta exitosa --
//        c.agregarAlCarrito(p1, 13);
//        c.agregarAlCarrito(p2, 15);
//        OperacionTienda.Venta(t, c);
//        System.out.println(t);

        //CU: Intento de venta con más de 3 productos --
//        c.agregarAlCarrito(p1, 13);
//        c.agregarAlCarrito(p2, 15);
//        c.agregarAlCarrito(p3, 13);
//        c.agregarAlCarrito(p4, 13);
//        OperacionTienda.Venta(t, c);
//        System.out.println(t);

        //CU: Intento de venta con más de 12 unidades por producto --
//        c.agregarAlCarrito(p1, 15);
//        c.agregarAlCarrito(p3, 13);
//        c.agregarAlCarrito(p4, 15);
//        OperacionTienda.Venta(t, c);
//        System.out.println(t);

        //CU: Intento de venta con producto no disponible --
//        c.agregarAlCarrito(p2, 15);
//        OperacionTienda.Venta(t, c);
//        System.out.println(t);
//        c.agregarAlCarrito(p2, 15);
//        OperacionTienda.Venta(t, c);

        //CU:Obtener comestibles con menor desc
//        OperacionTienda.obtenerComestiblesConMenorDescuento(t, 5.9);
        
    }

}