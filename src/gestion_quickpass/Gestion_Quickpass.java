
package gestion_quickpass;
import java.util.Arrays;

public class Gestion_Quickpass {
    private Quickpass[]quickPassArray; //Quickpass vigentes
    private Quickpass[] quickPassEliminados; //Quickpass eliminados
    private int capacidad;
    private int capacidadMaxima;
    private int numeroElementosEliminados; 

    //Inicia la instancia
    public Gestion_Quickpass(int capacidadMaxima){ //Cambié el nombre de la variable para no generar ambigüedad
        //inicia quickPassArray con el tamaño de capacidad
        quickPassArray = new Quickpass[capacidadMaxima];
        quickPassEliminados = new Quickpass[capacidadMaxima];
        this.capacidadMaxima = capacidadMaxima;
        this.capacidad= 0; // se rastrea el numero de elementos actuales en el arreglo 
        this.numeroElementosEliminados = 0;
    }
// para crear el quickpass añade un nuevo objeto al arreglo
    public void agregarquickpass(String filial, String codigo, String placa, String estado) {
    // Verificar si hay espacio en el arreglo
        if (this.capacidad >= this.quickPassArray.length) {
            System.out.println("No hay espacio para añadir más dispositivos Quickpass");
            return;
        }

    // Validación del código: 10 dígitos y empieza con "101"
        if (codigo.length() == 10 && codigo.startsWith("101")) {
        // Se agrega el nuevo Quickpass al arreglo
            this.quickPassArray[this.capacidad++] = new Quickpass(filial, codigo, placa, estado);
            System.out.println("Quickpass añadido exitosamente.");
        } 
        
        else {
            System.out.println("Código inválido. Debe ser de 10 dígitos y comenzar con '101'.");
        }
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
            qp.setEstado(nuevoEstado);
        }   
        else{
            System.out.println("QuickPass no encontrado");
        }
    }
    
        
    //Eliminar

    public void Eliminar(int indice) {
        // Mover el Quickpass eliminado 
        this.quickPassEliminados[this.numeroElementosEliminados++] = this.quickPassArray[indice];

        // Reemplazar el elemento eliminado con el último elemento del arreglo principal
        this.quickPassArray[indice] = this.quickPassArray[capacidad - 1];
        this.quickPassArray[this.capacidad - 1] = null;
        this.capacidad--; 
    }
   
 
    public void borraQuickPassPorCodigo(String codigo){ //Borra el quickpass por codigo y el elimiando lo pasa al array de elimados
        for (int i = 0; i < this.capacidad; i++) {
            if (this.quickPassArray[i].getCodigo().equals(codigo)) {
                Eliminar(i); //método creado para eliminar 
                System.out.println("Quickpass eliminado exitosamente.");
                return;
            } 
        } 
    }
 
    public void borraQuickPassPorPlaca(String placa){ //borra por placa
        for (int i = 0; i < capacidad; i++) {
            if (this.quickPassArray[i].getCodigo().equals(placa)) {
                Eliminar(i);
                System.out.println("Quickpass eliminado exitosamente.");
                return;
            } 
        } 
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


    
public static void main(String[] args){

        
      
    
    Gestion_Quickpass gestion= new Gestion_Quickpass(3);
        
        //Añadir
    gestion.agregarquickpass("Filial1","001", "ABC123", "Activo");
    gestion.agregarquickpass("Filial2","002", "DEF456", "Inactivo");
        
        //Listar
    gestion.listQuickPasses();
        
        //Leer
    System.out.println("001");
        
        //Actualizar
    gestion.actualizaQuickPass("001", "Filial3", "GHI789","Activo");
        
        //eliminar
        
    gestion.borraQuickPassPorCodigo("002");
        
        //Listar nuevamente
    gestion.listQuickPasses();
        
    gestion.agregarquickpass("Filial A", "1011234567", "ABC123", "Activo");
        
    System.out.println("\nIntentando agregar un Quickpass con código inválido (menos de 10 dígitos):");
    gestion.agregarquickpass("Filial B", "10112345", "DEF456", "Activo");
        
        System.out.println("\nIntentando agregar un Quickpass con código inválido (no empieza con 101):");
        gestion.agregarquickpass("Filial C", "2011234567", "GHI789", "Activo");

        System.out.println("\nIntentando agregar más Quickpass hasta llenar el arreglo:");
        gestion.agregarquickpass("Filial D", "1012345678", "JKL012", "Activo");
        gestion.agregarquickpass("Filial E", "1013456789", "MNO345", "Activo");
        gestion.agregarquickpass("Filial F", "1014567890", "PQR678", "Activo");


        gestion.agregarquickpass("Filial G", "1015678901", "STU901", "Activo");

     
    }
}
    
    

