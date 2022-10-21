package dto;
public class DTOPrestamoCilindro {
    int CodigoPrestamo;
    int CodCilindro;
    int Cantidad;
    
    public DTOPrestamoCilindro(){
        
    }
    
    public DTOPrestamoCilindro(int CodigoPrestamo,int CodCilindro, int Cantidad){
        this.CodigoPrestamo = CodigoPrestamo;
        this.CodCilindro = CodCilindro;
        this.Cantidad = Cantidad;
    }

    public int getCodigoPrestamo() {
        return CodigoPrestamo;
    }

    public void setCodigoPrestamo(int CodigoPrestamo) {
        this.CodigoPrestamo = CodigoPrestamo;
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
    
}
