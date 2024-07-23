package gestion_quickpass;


public class Quickpass {
    private String filial;
    private String codigo;
    private String placa;
    private String Estado;
    
    public Quickpass(String filial, String codigo, String placa, String Estado){
        this.filial = filial;
        this.codigo = codigo;
        this.placa = placa;
        this.Estado = Estado;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
        
    }    
        
    public String losStrings(){
        return "Quickpass{" + "filial= '"+ filial + '\'' + ",codigo= '"+ codigo + '\'' +  ",placa= " + placa + '\'' + ",Estado= "+ Estado + '\'' +'}';
        

        
    }
    
}
