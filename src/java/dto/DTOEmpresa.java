package dto;
public class DTOEmpresa {
    
    private String nit;
    private String nombre;
    
    public DTOEmpresa(){

    }
    
    public DTOEmpresa(String nit, String nombre){
        this.nit = nit;
        this.nombre = nombre;
       }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
