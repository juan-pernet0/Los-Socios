package dto;

public class DTOPedido {
    
    private int codigo;
    private String DocCliente;
    private String DocEmpleado;
    private String  fechapedido;
    private String fechaentrega;
    private String nombredestinatario;
    private String documentodestinatario;
    private int Precio_Domicilio;

    public DTOPedido() {
    }

    public DTOPedido(int codigo, String DocCliente, String DocEmpleado, String fechapedido, String fechaentrega, String nombredestinatario, String documentodestinatario, int Precio_Domicilio) {
        this.codigo = codigo;
        this.DocCliente = DocCliente;
        this.DocEmpleado = DocEmpleado;
        this.fechapedido = fechapedido;
        this.fechaentrega = fechaentrega;
        this.nombredestinatario = nombredestinatario;
        this.documentodestinatario = documentodestinatario;
        this.Precio_Domicilio = Precio_Domicilio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDocCliente() {
        return DocCliente;
    }

    public void setDocCliente(String DocCliente) {
        this.DocCliente = DocCliente;
    }

    public String getDocEmpleado() {
        return DocEmpleado;
    }

    public void setDocEmpleado(String DocEmpleado) {
        this.DocEmpleado = DocEmpleado;
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

    public int getPrecio_Domicilio() {
        return Precio_Domicilio;
    }

    public void setPrecio_Domicilio(int Precio_Domicilio) {
        this.Precio_Domicilio = Precio_Domicilio;
    }

    
    
    
    
}
