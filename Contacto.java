import java.util.Scanner;
/**
 * Representa un contacto de la agenda, con nombre, localidad, direccion y hasta 5 nùmeros de telèfono.
 * 
 * @author Ignacio Perez
 * @author Barrionuevo Francisco
 * @version 1.0
 */
public class Contacto{
    
    //Atributos de la clase 
    private String nombre;
    private String localidad;
    private String direccion;
    private String[] telefono;
    
    /**
     * Crea un contacto, guarda nombre, localodad y direcciòn en mayùscula.
     * Asigna "S/D" si estan vacios o con espacios en blanco
     * @param nombre el nombre del contacto
     * @param localidad la coladidad del contacto
     * @param direcciòn la direcciòn del contacto
     * @param telèfono el telèfono del contacto(carateristica-numero)
     */
    public Contacto(String nombre, String localidad, String direccion, String telefono){
        this.telefono = new String[5];

        setNombre(nombre);
        setLocalidad(localidad);
        setDireccion(direccion);

        if(telefono==null || telefono.trim().isEmpty()){
            agregarTelefono();
        }else{
            this.telefono[0]=telefono.trim();
        }

    }
    
    //getters y setters
    /** 
     * Devuelve el nombre del contacto
     * @return el nombre del contacto
     */
    public String getNombre(){ return this.nombre;}
    /**
     * Valida y asigna el nombre del contacto 
     * @param nombre el nombre del contacto en mayúscula 
     */
    public void setNombre(String nombre){
        this.nombre=(nombre==null || nombre.trim().isEmpty()) ? "S/D" : nombre.trim().toUpperCase();
    }
    
    /**
     * Devuelve la localidad del contacto
     * @return localidad del contacto
     */
    public String getLocalidad(){ return this.localidad;}
    /**
     * Valida y asigna la localidad del contacto
     * @param localidad la localidad del contacto en mayúscula 
     */
    public void setLocalidad(String localidad){
        this.localidad=(localidad==null || localidad.trim().isEmpty()) ? "S/D" : localidad.trim().toUpperCase();
    }
    
    /**
     * Devuelve la direccion del contacto
     * @return direccion del contacto
     */
    public String getDireccion(){ return this.direccion;}
    /**
     * Valida y asigna la dirección del contacto
     * @param dirección la dirección del contacto en mayúscula 
     */
    public void setDireccion(String direccion){
        this.direccion=(direccion==null || direccion.trim().isEmpty()) ? "S/D" : direccion.trim().toUpperCase();
    }
    
    /**
     * Retorna la posición del primer elemento vacío del arreglo, o -1, si no hay ninguno.
     * @return la posicion del primer elemento vacio del arreglo, si no hay posiciones vacias -1.
     */
    public int elementoVacio(){
        for(int i=0; i<telefono.length; i++){
            if(telefono[i]==null || telefono[i].trim().isEmpty()){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Indica si la característica electronica es correcta.
     * @param c la caracteristica a validar.
     * @return false cuando c es nullo, vacio o con espacios en blanco.
     * @return false cuando no son numeros o no empieza con 0.
     * @return true si es un número de 0 a 9, false si es otra  cosa.
     */
    public boolean validarCaracteristica(String c){
        if(c==null || c.length()<3 ||c.length()>5){
            return false;
        }
        if(c.charAt(0)!='0'){
            return false;
        }
        for(int i=0; i<c.length(); i++){
            if(!Character.isDigit(c.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Indica si el número telefónico es correcto.
     * @return true cuando n está entre 10000 y 9999999 false.
     */
    public boolean validarNumero(int n){
        return (n>=10000 && n<=9999999);
    }
    
    /**
     * Indica si p corresponde a un teléfono cargado según la numeracion del listado.
     * @param p la posicion a validar.
     * @return true cuando p esta entre 1 y 5 caso contrario false
     * @return false cuando es nulo o vacio caso contrario true.
     */
    public boolean validarPosicion(int p){
        if(p<1 || p>5){
            return false;
        }
        if(telefono[p-1]==null || telefono[p-1].trim().isEmpty()){
            return false;
        }
        return true;
    }
    
    /**
     * Solicita por teclado caracteristica y número, los valida y guarda el teléfono en el primer elemento vacío del arreglo.
     */
    public void agregarTelefono(){
        //Verificar lugares vacios
        int pos=elementoVacio();
        if(pos==-1){
            System.out.println("No existe mas lugar para agregar numeros telefonicos");
            return;
        }
        //Validar caracteristica
        Scanner sc = new Scanner(System.in);
        String caracteristica;
        do{
            System.out.println("Ingrese la caracteristica");
            caracteristica=sc.nextLine().trim();
            if(!validarCaracteristica(caracteristica)){
                System.out.println("Caracteristica invalida, ingresela de nuevo");
            }

        }while(!validarCaracteristica(caracteristica));
        //Validar numero
        int numero;
        do{
            System.out.println("Ingrese el numero");
            numero=sc.nextInt();
            if(!validarNumero(numero)){
                System.out.println("Numero invalido, ingreselo de nuevo");
            }

        }while(!validarNumero(numero));
        telefono[pos]=caracteristica + "-" + numero;
    }
    
    /**
     * Sobrecarga. Guarda en el primer elemento vacío el teléfono recibido por parámetro.
     * @param caracteristica la caracteristica telefonica 
     * @param numero el numero de telefono
     */
    public void agregarTelefono(String caracteristica, int numero){
        int pos=elementoVacio();
        if(pos==-1){
            System.out.println("No existe mas lugar para agregar numeros telefonicos");
            return;
        }else{
            telefono[pos]=caracteristica + "-" + numero;
        }
    }
    
    /**
     * Muestra por pantalla los teléfonos cargados, numerados.
     */
    public void listarTelefonos(){
        boolean hayAlguno = false;              
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].trim().isEmpty()) {
                System.out.println((i + 1) + ") " + telefono[i]);
                hayAlguno = true;               
            }
        }
        if (!hayAlguno) {                      
            System.out.println("No existen numeros de telefonos en la lista");
        }
    }
    
    /**
     * Elimina un teléfono cargado, elegido por su posicion en el listado
     */
    public void eliminarTelefono(){
        boolean hayAlguno = false;              
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].trim().isEmpty()) {
                hayAlguno = true;               
            }
        }
        if (!hayAlguno) {                      
            System.out.println("No existen nÃºmeros de telÃ©fonos en la lista");
            return;
        }
        
        listarTelefonos();
    
        Scanner sc = new Scanner(System.in);
        int posicion;
        
        do{
            System.out.println("Ingrese la posicion del telefono que quiere eliminar");
            posicion = sc.nextInt();
            if(!validarPosicion(posicion)){
                System.out.println("Posicion invalida, ingresela de nuevo");
            }
        }while(!validarPosicion(posicion));
        
        telefono[posicion - 1] = "";
    }
    
    /**
     * Reemplaza un teléfono cargado, elegido por su posicion en el listado por uno nuevo ingresado por teclado
     */
    public void modificarTelefono(){
        boolean hayAlguno = false;              
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].trim().isEmpty()) {
                hayAlguno = true;               
            }
        }
        if (!hayAlguno) {                      
            System.out.println("No existen nÃºmeros de telÃ©fonos en la lista para modificar");
            return;
        }
        
        listarTelefonos();
        
        Scanner sc = new Scanner(System.in);
        int posicion;
        do{
            System.out.println("Ingrese la posicion del telefono que quiere modificar");
            posicion = sc.nextInt();
            if(!validarPosicion(posicion)){
                System.out.println("Posicion invalida, ingresela de nuevo");
            }
        }while(!validarPosicion(posicion));
        
        sc.nextLine();
        
        String caracteristica;
        do{
            System.out.println("Ingrese la caracteristica");
            caracteristica=sc.nextLine().trim();
            if(!validarCaracteristica(caracteristica)){
                System.out.println("Caracteristica invalida, ingresela de nuevo");
            }

        }while(!validarCaracteristica(caracteristica));
        
        int numero;
        do{
            System.out.println("Ingrese el numero");
            numero=sc.nextInt();
            if(!validarNumero(numero)){
                System.out.println("Numero invalido, ingreselo de nuevo");
            }

        }while(!validarNumero(numero));
        telefono[posicion - 1]=caracteristica + "-" + numero;
    }
}

