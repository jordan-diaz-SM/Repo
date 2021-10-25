package tienda.models;

public class Cliente {
    private String id;
    private String nombre;
    private String direccion;
    private String numeroDocumento;

    public Cliente() {}

    public Cliente(String numeroDocumento) { 
        this.numeroDocumento = numeroDocumento; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre)    {
        this.nombre = nombre;
    }

    public String getNombre()   {
        return this.nombre;
    }

    public void setDireccion(String direccion)    {
        this.direccion = direccion;
    }

    public String getDireccion()   {
        return this.direccion;
    }

    public void setNumeroDocumento(String numeroDocumento)    {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento()   {
        return this.numeroDocumento;
    }

    public String imprimeDatosCliente()  {

        StringBuffer salida = new StringBuffer();
        salida.append("Cliente Id: " + this.numeroDocumento);
        salida.append("\nNombres: " + this.nombre);
        salida.append("\nDireccion: " + this.direccion);
        return salida.toString();
    }
}