package dto;
public class DTODevolucionCilindro {
    private String CodDevolucion;
    private String CodCilindros;
    private int Cantidad;

    public DTODevolucionCilindro() {
    }

    public DTODevolucionCilindro(String CodDevolucion, String CodCilindros, int Cantidad) {
        this.CodDevolucion = CodDevolucion;
        this.CodCilindros = CodCilindros;
        this.Cantidad = Cantidad;
    }

    public String getCodDevolucion() {
        return CodDevolucion;
    }

    public void setCodDevolucion(String CodDevolucion) {
        this.CodDevolucion = CodDevolucion;
    }

    public String getCodCilindros() {
        return CodCilindros;
    }

    public void setCodCilindros(String CodCilindros) {
        this.CodCilindros = CodCilindros;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    
    
    
}
