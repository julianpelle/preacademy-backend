package main.primera_evaluación.service;

import main.primera_evaluación.model.*;

import java.util.ArrayList;

public class CarritoService{
    public static void main(String[] args) {

        // Crear al menos 3 productos utilizando el patrón Builder

        Producto prod1 = new Producto()
                .id(1)
                .nombre("Camiseta")
                .precio(2500)
                .categoria("Ropa");

        Producto prod2 = new Producto()
                .id(2)
                .nombre("Pantalon")
                .precio(4500)
                .categoria("Ropa");

        Producto prod3 = new Producto()
                .id(3)
                .nombre("Notebook")
                .precio(60000)
                .categoria("Computacion");

        // Crear un carrito y agregar productos

        Cliente cliente1 = (Cliente) new Cliente()
                .nombreCompleto("Julian Pellegrini")
                .id(1L).nombreUsuario("Juli123")
                .contraseña("123Juli!");

        Carrito carrito = new Carrito().cliente(cliente1);
        carrito.agregarProducto(prod1, 2);
        carrito.agregarProducto(prod2, 1);
        carrito.agregarProducto(prod3, 1);

        // Aplicar un cupón de descuento

        carrito.mostrarResumen();

        Cupon cupon = new Cupon("HOTSALE", 0.30);
        carrito.aplicarCupon(cupon);

        // Calcular y mostrar: Subtotal | Total con descuento | Items filtrados por categoría | Cantidad total de productos |
        // Promedio de precios |

        // Subtotal
        System.out.println("subtotal: $" + carrito.calcularSubtotal() + "\n");

        // Total con descuento
        System.out.println("Total con descuento: $" + carrito.calcularTotalConDescuento() + "\n");

        // Items filtrados por categoría
        String categoriaFiltrar = "Ropa";
        ArrayList<ItemCarrito> filtrados = (ArrayList<ItemCarrito>) carrito.obtenerItemsPorCategoria(categoriaFiltrar);
        System.out.println("Items del carrito en la categoría '" + categoriaFiltrar + "':");
        filtrados.forEach(item -> System.out.println(item.getProducto().getNombre() + " | total unidades: " + item.getCantidad()));

        // Cantidad total de productos
        System.out.println("\n" +"Cantidad total de productos en el carrito: " + carrito.obtenerCantidadTotalProductos() + "\n");

        // Promedio de precios
        System.out.println("Promedio de precio por unidad: $" + carrito.obtenerPromedioPrecioProductos() + "\n");


        //Mostrar un resumen final en consola con los datos del carrito
        carrito.mostrarResumen();


        //EXTRA PROBAR QUITAR
        carrito.quitarProductoPorId(4);
        carrito.quitarProductoPorId(3);
        carrito.quitarProductoPorId(1);
        System.out.println("\n" +"Cantidad total de productos en el carrito: " + carrito.obtenerCantidadTotalProductos() + "\n");
        carrito.mostrarResumen();

    }
}
