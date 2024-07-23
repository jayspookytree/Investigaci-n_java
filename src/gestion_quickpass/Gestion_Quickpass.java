
package gestion_quickpass;
import java.util.Arrays;

public class Gestion_Quickpass {
    private Quickpass[]quickPassArray;
    private int capacidad;
    
    //Inicia la instancia
    public Gestion_Quickpass(int capacidad){
        //inicia quickPassArray con el tamaño de capacidad
        quickPassArray = new Quickpass[capacidad];
        this.capacidad= 0; // se rastrea el numero de elementos actuales en el arreglo 
    }
// para crear el quickpass añade un nuevo objeto al arreglo
    public void agregaQuickPass(String filial, String codigo, String placa, String Estado){
        // el ig=f verifica si el arreglo esta lleno
        if(capacidad >= quickPassArray.length){
            System.out.println("Nos se pueden añadir más Quickpass!! ");
            return;
        }
        quickPassArray[capacidad ++]= new Quickpass(filial, codigo, placa, Estado);
    }
//Leer el quickpass, busca y devuelve un quickpass que tenga el codigo especificado
public Quickpass getQuickPass(String codigo){
    // for itera sobre cada elemento de quickPassArray
    for(Quickpass qp: quickPassArray){
        // if comprueba si el elemento qp no es null y si los codigos coiciden
        if(qp!= null && qp.getCodigo().equals(codigo)){
            return qp;
        }
    }
    return null;
}    

// Actualizar los detalles de un QuickPass existente
public void actualizaQuickPass(String codigo, String nuevaFilial, String nuevaPlaca, String nuevoEstado){
    //llama al metodo get para encontrar el QuickPass con el codigo especificado
    Quickpass qp = getQuickPass(codigo);
    // si encuentra uno y qp no es null, actualiza los atributos
    if(qp != null){
        qp.setFilial(nuevaFilial);
        qp.setPlaca(nuevaPlaca);
        qp. setEstado(nuevoEstado);
    }else{
        System.out.println("QuickPass no encontrado");
    }
}
//Eliminar
public void borraQuickPass(String codigo){
    for(int i = 0; i < capacidad; i++ ){
        if (quickPassArray[i].getCodigo().equals(codigo)){
            quickPassArray[i]= quickPassArray[capacidad -1];
            quickPassArray[capacidad -1]= null;
            capacidad --;
            return;
        }
    }
    System.out.println("QuickPass no encontrado");
}

//listado, si el elemento actual de qp no es null imprime los detalles del QuickPass
public void listQuickPasses(){
    System.out.println("Lista de QuickPasses:");
    for(Quickpass qp : quickPassArray){
        if (qp != null){
            System.out.println(qp);
        }
    }
}
    public static void main(String[] args) {
        Gestion_Quickpass gestion= new Gestion_Quickpass(10);
        
        //Añadir
        gestion.agregaQuickPass("Filial1","001", "ABC123", "Activo");
        gestion.agregaQuickPass("Filial2","002", "DEF456", "Inactivo");
        
        //Listar
        gestion.listQuickPasses();
        
        //Leer
        System.out.println("001");
        
        //Actualizar
        gestion.actualizaQuickPass("001", "Filial3", "GHI789","Activo");
        
        //eliminar
        
        gestion.borraQuickPass("002");
        
        //Listar nuevamente
        gestion.listQuickPasses();
    }
    
}
