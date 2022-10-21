package dto;

/**
 *
 * @author user
 */
public class DTOLlenado_Cilindros {
    int CodigoLlenado;
    int CodCilindro;
    int Cantidad;
    int Precio;

    public DTOLlenado_Cilindros() {
    }

    public DTOLlenado_Cilindros(int CodigoLlenado, int CodCilindro, int Cantidad, int Precio) {
        this.CodigoLlenado = CodigoLlenado;
        this.CodCilindro = CodCilindro;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    public int getCodigoLlenado() {
        return CodigoLlenado;
    }

    public void setCodigoLlenado(int CodigoLlenado) {
        this.CodigoLlenado = CodigoLlenado;
    }

    public int getCodCilindro() {
        return CodCilindro;
    }

    public void setCodCilindro(int CodCilindro) {
        this.CodCilindro = CodCilindro;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public int getPrecio() {
        return Precio;
    }

    public void Precio(int Precio) {
        this.Precio = Precio;
    }
}
