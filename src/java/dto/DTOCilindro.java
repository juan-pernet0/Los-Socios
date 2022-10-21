package dto;
public class DTOCilindro{
    
    //private int codigo;
    private int codigo;
    private int capacidad;
    private int precio;
    private String empresa;
    private int Cilindros_llenos;
    private int Cilindros_Vacios;
    private int Cilindros_Prestados;

    public DTOCilindro() {

    }

    public DTOCilindro(int codigo, int capacidad, int precio, String empresa, int Cilindros_llenos, int Cilindros_Vacios, int Cilindros_Prestados) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.empresa = empresa;
        this.Cilindros_llenos = Cilindros_llenos;
        this.Cilindros_Vacios = Cilindros_Vacios;
        this.Cilindros_Prestados = Cilindros_Prestados;
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

    public int getCilindros_llenos() {
        return Cilindros_llenos;
    }

    public void setCilindros_llenos(int Cilindros_llenos) {
        this.Cilindros_llenos = Cilindros_llenos;
    }

    public int getCilindros_Vacios() {
        return Cilindros_Vacios;
    }

    public void setCilindros_Vacios(int Cilindros_Vacios) {
        this.Cilindros_Vacios = Cilindros_Vacios;
    }

    public int getCilindros_Prestados() {
        return Cilindros_Prestados;
    }

    public void setCilindros_Prestados(int Cilindros_Prestados) {
        this.Cilindros_Prestados = Cilindros_Prestados;
    }

    

    
    
  
    
    
}
