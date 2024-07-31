
package gestion_quickpass;

public class punto4 {
        private Quickpass[] quickpassArray; // con el arreglo es para almacenar objeto quickpass y contador para llevar la cuenta del número de quickpass
        private int capacidad;
        //Constructor
        
        public punto4(int capacidad) {
        quickpassArray = new Quickpass[capacidad];
        this.capacidad = 0;
        }
        
    //se agrega un nuevo quickpas por un método
        public void agregarquickpass(String filial, String codigo, String placa, String estado) {
    // Verificar si hay espacio en el arreglo
    if (capacidad >= quickpassArray.length) {
        System.out.println("No hay espacio para añadir más dispositivos Quickpass");
        return;
    }

    // Validación del código: 10 dígitos y empieza con "101"
    if (codigo.length() == 10 && codigo.startsWith("101")) {
        // Se agrega el nuevo Quickpass al arreglo
        quickpassArray[capacidad++] = new Quickpass(filial, codigo, placa, estado);
        System.out.println("Quickpass añadido exitosamente.");
    } else {
        System.out.println("Código inválido. Debe ser de 10 dígitos y comenzar con '101'.");
    }
}

    public Quickpass consultarQP(String codigo){
        for(Quickpass qp: quickpassArray){
            if (qp != null && qp.getCodigo().equals(codigo)){
                return qp;
       }  
    }
    return null;
}

public void eliminarQuickPass(String codigo){
    for(int i = 0; i< capacidad; i++){
        if (quickpassArray[i].getCodigo().equals(codigo)){
            quickpassArray[i]= quickpassArray[capacidad -1]= null;
            quickpassArray[capacidad -1]= null;
            capacidad --;
            return;
        }
    }
    System.out.println("Quickpass no encontrado");
}
public void listarQuickPass(){
    System.out.println("Lista de Quickpasses");
    for(Quickpass qp :quickpassArray){
        if(qp != null){
            System.out.println(qp);
        }
    }
}
public void actualizarquickpass(String codigo, String nuevaFilial, String nuevaPlaca, String nuevoEstado){
    Quickpass qp = consultarQP(codigo);
    if(qp != null){
       qp.setFilial(nuevaFilial);
       qp.setPlaca(nuevaPlaca);
       qp.setEstado(nuevoEstado);
       
    } else { 
        System.out.println("Quickpass no encontrado");    
    }
}  

}
