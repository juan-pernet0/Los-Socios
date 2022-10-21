package dto;
public class DTOUsuario {
    
    private String documento;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private String rol;

    public DTOUsuario(){
        
    }
    
     public DTOUsuario(String documento,String nombres,String apellidos, String direccion,String telefono, String email, String password, String rol){
         this.documento = documento;
         this.nombres = nombres;
         this.apellidos = apellidos;
         this.direccion = direccion;
         this.telefono = telefono;
         this.email = email;
         this.password = password;
         this.rol = rol;
    
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
    return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }
    
      public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
