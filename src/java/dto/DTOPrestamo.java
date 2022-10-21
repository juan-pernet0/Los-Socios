package dto;

public class DTOPrestamo {
    private int Codigo;
    private String DocEmpleado;
    private String DocCliente;
    private String fechapedido;
    private String fechaentrega;
    private String nombredestinatario;
    private String documentodestinatario;
    private int Precio_Domi;

    public DTOPrestamo() {
    }

    public DTOPrestamo(int Codigo, String DocEmpleado, String DocCliente, String fechapedido, String fechaentrega, String nombredestinatario, String documentodestinatario, int Precio_Domi) {
        this.Codigo = Codigo;
        this.DocEmpleado = DocEmpleado;
        this.DocCliente = DocCliente;
        this.fechapedido = fechapedido;
        this.fechaentrega = fechaentrega;
        this.nombredestinatario = nombredestinatario;
        this.documentodestinatario = documentodestinatario;
        this.Precio_Domi = Precio_Domi;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDocEmpleado() {
        return DocEmpleado;
    }

    public void setDocEmpleado(String DocEmpleado) {
        this.DocEmpleado = DocEmpleado;
    }

    public String getDocCliente() {
        return DocCliente;
    }

    public void setDocCliente(String DocCliente) {
        this.DocCliente = DocCliente;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getNombredestinatario() {
        return nombredestinatario;
    }

    public void setNombredestinatario(String nombredestinatario) {
        this.nombredestinatario = nombredestinatario;
    }

    public String getDocumentodestinatario() {
        return documentodestinatario;
    }

    public void setDocumentodestinatario(String documentodestinatario) {
        this.documentodestinatario = documentodestinatario;
    }

    public int getPrecio_Domi() {
        return Precio_Domi;
    }

    public void setPrecio_Domi(int Precio_Domi) {
        this.Precio_Domi = Precio_Domi;
    }
    
    
   
    
}