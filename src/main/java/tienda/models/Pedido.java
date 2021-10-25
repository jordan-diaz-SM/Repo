package tienda.models;

import java.util.List;
import tienda.models.interfaces.IPedidoDetalle;


public class Pedido {
    private String id;
    private Double montoTotal;
    private String direccionEntrega;
    private String cliente;
    private List<IPedidoDetalle> detallePedido;
    private Cliente clienteObj;

    public Pedido() {}

    public Cliente getClienteObj() {
        return clienteObj;
    }

    public void setClienteObj(Cliente clienteObj) {
        this.clienteObj = clienteObj;
    }

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<IPedidoDetalle> getDetallePedido() {
        //List<IOrderItem> ordersItems = new ArrayList<>();
        return detallePedido;
    }

    public void setDetallePedido(List<IPedidoDetalle> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public void asignaClientePedido(String cliente) {
       
        System.out.println("Cliente que quiere el pedido: " + cliente);
        this.setCliente(cliente);
    }

    public Double calcularMontoPedido() {
        List<IPedidoDetalle> detallePedido = this.getDetallePedido();

        Double total = 0.0;

        for (IPedidoDetalle item : detallePedido) {
            total += item.getPrecio();
        }

        return total;
    }

    public void pagar(MetodoPago paymentMethod)   {

        System.out.println("Paying order ...");
        paymentMethod.pagarPedido(this);
    }
}