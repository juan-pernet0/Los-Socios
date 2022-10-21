package dto;
public class DTORol {
    private String Rol;
    private String Nombres;
    
    public DTORol(){
        
    }
    
    public DTORol(String Rol,String Nombres){
        this.Rol = Rol;
        this.Nombres = Nombres;   
    }
    
    public String getRol() {
        return Rol;
    }
    
    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    public String getNombres(){
        return Nombres;
    }
    
    public void setNombres(String Nombres){
        this.Nombres = Nombres;
    }
}
