package dtos;

public class ResumenDTO {
    private String nombre;
    private String tipo;
    private int cantidad;
    private String distribuidor;
    private boolean sucursalPrincipal;
    private boolean sucursalSecundaria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public boolean isSucursalPrincipal() {
        return sucursalPrincipal;
    }

    public void setSucursalPrincipal(boolean sucursalPrincipal) {
        this.sucursalPrincipal = sucursalPrincipal;
    }

    public boolean isSucursalSecundaria() {
        return sucursalSecundaria;
    }

    public void setSucursalSecundaria(boolean sucursalSecundaria) {
        this.sucursalSecundaria = sucursalSecundaria;
    }
}
