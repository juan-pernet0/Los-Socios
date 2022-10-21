
package dto;
public class DTOCarrito {
    
    private int item;
    private int codigo;
    private int capacidad;
    private int precio;
    private String empresa;    
    int cantidad;
    double subTotal;

    public DTOCarrito() {
    }

    public DTOCarrito(int item, int codigo, int capacidad, int precio, String empresa, int cantidad, double subTotal) {
        this.item = item;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.empresa = empresa;
        this.cantidad = cantidad;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    
    
}
