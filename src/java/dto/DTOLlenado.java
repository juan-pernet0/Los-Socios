package dto;

import java.util.Date;

public class DTOLlenado {
    
    private String nitEmpresa;
    private String fechallenado;
    private int Codigo ;
    
    public DTOLlenado(){
    
    }
    
    public DTOLlenado(int Codigo, String fechallenado, String nitEmpresa){
        this.nitEmpresa = nitEmpresa;
        this.fechallenado = fechallenado;
        this.Codigo = Codigo;
    
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
    public String getNitEmpresa(){
        return nitEmpresa;
    }
    public void setCodEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }
    public String getFechallenado() {
        return fechallenado;
    }

    public void setFechallenado(String fechallenado) {
        this.fechallenado = fechallenado;
    }
    
}