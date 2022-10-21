package dto;
public class DTODevolucion {
    private int codigo;
    private String CodPrestamo;
    private String DocEmpleado;    
    private String FechaDevolucion;

    public DTODevolucion() {
    }

    public DTODevolucion(int codigo, String CodPrestamo, String DocEmpleado, String FechaDevolucion) {
        this.codigo = codigo;
        this.CodPrestamo = CodPrestamo;
        this.DocEmpleado = DocEmpleado;
        this.FechaDevolucion = FechaDevolucion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodPrestamo() {
        return CodPrestamo;
    }

    public void setCodPrestamo(String CodPrestamo) {
        this.CodPrestamo = CodPrestamo;
    }

    public String getDocEmpleado() {
        return DocEmpleado;
    }

    public void setDocEmpleado(String DocEmpleado) {
        this.DocEmpleado = DocEmpleado;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    
    
}
