
package dto;

public class DTOCarritoLlenado {
    private int item;
    private int codigo;
    private String empresa;  
    private int capacidad;
    private int precio;
    int cantidad;
    int subTotal;

    public DTOCarritoLlenado() {
    }
    
    public DTOCarritoLlenado(int item, int codigo, String empresa, int capacidad,int cantidad , int precio, int subTotal) {
        this.item = item;
        this.codigo = codigo;
        this.empresa = empresa;
        this.capacidad = capacidad;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
}
