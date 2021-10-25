package tienda.models;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class BlockChainMetodoPago extends MetodoPago {

    private String walletId;
    private Double comision;

    @Override
    public  void pagarPedido(Pedido order){
        walletPayOrder(order);
    }

    public void walletPayOrder(Pedido order){
        
        comision = order.getMontoTotal() * 0.05;
        /* Doing Blok Chain Validation */
        System.out.println("Procesando el pago con wallet "+getWalletId()+" | total: "+order.getMontoTotal() + " comision: " +comision);
    }

    public String getWalletId() {
        if(this.walletId == null){
            UUID uuid = Generators.timeBasedGenerator().generate();
            setWalletId(uuid.toString());
        }
        return walletId;
    }

    public void setWalletId(String walletId){
        this.walletId = walletId;
    }
}
