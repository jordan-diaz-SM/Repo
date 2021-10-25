package tienda.models;

public class MetodoPago {

    public void pagarPedido(Pedido order){

        /* Efectivo */
        System.out.println("Pagando con efectivo | total: "+ order.getMontoTotal());
    }

}
