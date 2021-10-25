package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IPedidoDetalle;

public class PedidoDetallePromocion implements IPedidoDetalle {

    private String idProduct;
    private Integer cantidad;
    private Double precio;

    public PedidoDetallePromocion() {

    }
    
    public PedidoDetallePromocion(String idProduct, Integer cantidad, Double precio)  {
        this.idProduct = idProduct;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public Double calculaPrecio() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pedido getPedido() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getPrecio() {
        Double customPrice = 0.0;
        customPrice = this.precio * this.cantidad;

        // promo primera compra
        customPrice -= 20.0;

        if (customPrice < 0 ) {
            customPrice = 0.0;
        }
        return customPrice;
    }

    @Override
    public Integer getCantidad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPedido(Pedido order) {
        // TODO Auto-generated method stub

    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }    
}