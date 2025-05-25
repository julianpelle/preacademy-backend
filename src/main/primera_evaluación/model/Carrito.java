package main.primera_evaluación.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrito {

    private List<ItemCarrito> items;
    private Cupon cupon;
    private Cliente cliente;

    public Carrito(List<ItemCarrito> items, Cupon cupon, Cliente cliente) {
        this.items = items;
        this.cupon = cupon;
        this.cliente = cliente;
    }

    public Carrito() {
        items = new ArrayList<ItemCarrito>();
    }


    public Carrito items(List<ItemCarrito> items) {
        this.items = items;
        return this;
    }
    public Carrito cupon(Cupon cupon) {
        this.cupon = cupon;
        return this;
    }
    public Carrito cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }


    /*
     Podria haber usado anymatch de STREAM pero me retornaria un booleano y a mi me conviene saber tambien
     la posicion del producto para modificar su cantidad, si es que existe.
  */
    public void agregarProducto(Producto producto,int cantidad) {
        int indice = this.indiceProducto(producto);
        if(indice == -1){
            this.items.add(new ItemCarrito(producto, cantidad));
        }else{
            this.items.get(indice).setCantidad(cantidad);
        }
    }

    public int indiceProducto(Producto producto) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProducto().equals(producto)) {
                return i;
            }
        }
        return -1;

    }

    public void quitarProductoPorId(int idProducto) {
        int indice = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProducto().getId() == idProducto) {
                indice = i;
                break;
            }
        }
        if (indice != -1) {
            if(items.get(indice).getCantidad() > 1){
                items.get(indice).setCantidad(items.get(indice).getCantidad()-1);
            }else {
                items.remove(indice);
            }
        }else {
            System.out.println("El producto no existe");
        }
    }

    public double calcularSubtotal(){
        return items.stream().mapToDouble(ItemCarrito::calcularSubtotal).sum();
    }

    /*
    HABIA HECHO ESTE METODO QUE NO ME SIRVE PARA EL MOSTRAR RESUMEN

    public double calcularTotalConDescuento(){

        double decimal = 0;
        double subtotal = calcularSubtotal();

        if(cupon != null){
           decimal = cupon.getPorcentajeDescuento();
        }else {
            if(subtotal > 10000){
                decimal = 0.1;
            } else if (subtotal > 5000) {
                decimal = 0.05;
            }

        }

        return subtotal - (subtotal * decimal);
    }
 */


    public double calcularTotalConDescuento(){

        double subtotal = calcularSubtotal();
        double decimal = obtenerDecimalDescuento();

        return subtotal * (1-decimal);
    }


    public double obtenerDecimalDescuento(){
        double decimal = 0;
        double subtotal = calcularSubtotal();

        if(cupon != null){
            decimal = cupon.getPorcentajeDescuento();
        }else {
            if(subtotal > 10000){
                decimal = 0.1;
            } else if (subtotal > 5000) {
                decimal = 0.05;
            }
        }
        return decimal;
    }

    public void aplicarCupon(Cupon cupon) {
        this.cupon = cupon;
    }

    public List<ItemCarrito> obtenerItemsPorCategoria(String categoria){
       if(categoriaExists(categoria)){
           return items.stream()
                   .filter(item -> item.getProducto().getCategoria().equalsIgnoreCase(categoria))
                   .collect(Collectors.toList());
       }else {
           System.out.println("La categoria no existe en los items de este carrito");
           return null;
       }

    }

    public boolean categoriaExists(String categoria){
        return items.stream()
                .anyMatch(item -> item.getProducto().getCategoria().equalsIgnoreCase(categoria));
    }


    public int obtenerCantidadTotalProductos() {
        return items.stream().mapToInt(ItemCarrito::getCantidad).sum();
    }

  /*
    Intente este metodo pero me decia algo de Optional Double que no conozco bien como hacer
    public double obtenerPromedioPrecioProductos(){
        return items.stream().mapToDouble(ItemCarrito::calcularSubtotal).average();
    }
   */
  public double obtenerPromedioPrecioProductos() {
      int totalUnidades  = (int) items.stream().mapToDouble(ItemCarrito::getCantidad).sum();

      if(totalUnidades  == 0){
          return 0;
      }

      double subtotal = calcularSubtotal();
      return subtotal / totalUnidades ;
  }

    public void mostrarResumen(){
        System.out.println("========================= \n ->CARRITO<- \n");
      items.forEach(item -> System.out.println(item.getProducto().getNombre() + " VALOR: $"
              + item.getProducto().getPrecio() + "  CANT X " + item.getCantidad()
              + " | TOTAL PRODUCTO $" + item.calcularSubtotal() + "\n"));

      double subtotal = calcularSubtotal();
      double descuento = obtenerDecimalDescuento();
      double totalFinal = calcularTotalConDescuento();

        System.out.println("Subtotal: " + subtotal + " Descuento aplicable: " + descuento*100 +"%" + "\nTotal Final: " + totalFinal + "\n");
        System.out.println("========================= \n");
  }



}
