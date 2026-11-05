import java.util.Scanner;
public class Contacto{
    private String nombre;
    private String localidad;
    private String direccion;
    private String[] telefono;
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
    //nombre
    public String getNombre(){ return this.nombre;}

    public void setNombre(String nombre){
        this.nombre=(nombre==null || nombre.trim().isEmpty()) ? "S/D" : nombre.trim().toUpperCase();
    }
    //localidad
    public String getLocalidad(){ return this.localidad;}

    public void setLocalidad(String localidad){
        this.localidad=(localidad==null || localidad.trim().isEmpty()) ? "S/D" : localidad.trim().toUpperCase();
    }
    //direccion
    public String getDireccion(){ return this.direccion;}

    public void setDireccion(String direccion){
        this.direccion=(direccion==null || direccion.trim().isEmpty()) ? "S/D" : direccion.trim().toUpperCase();
    }

    public int elementoVacio(){
        for(int i=0; i<telefono.length; i++){
            if(telefono[i]==null || telefono[i].trim().isEmpty()){
                return i;
            }
        }
        return -1;
    }

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

    public boolean validarNumero(int n){
        return (n>=10000 && n<=9999999);
    }

    public boolean validarPosicion(int p){
        if(p<1 || p>5){
            return false;
        }
        if(telefono[p-1]==null || telefono[p-1].trim().isEmpty()){
            return false;
        }
        return true;
    }

    public void agregarTelefono(){
        int pos=elementoVacio();
        if(pos==-1){
            System.out.println("No existe mas lugar para agregar numeros telefonicos");
            return;
        }
        Scanner sc = new Scanner(System.in);
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
        telefono[pos]=caracteristica + "-" + numero;
    }
    
    public void agregarTelefono(String caracteristica, int numero){
        int pos=elementoVacio();
        if(pos==-1){
            System.out.println("No existe mas lugar para agregar numeros telefonicos");
            return;
        }else{
            telefono[pos]=caracteristica + "-" + numero;
        }
    }
    
    public void listarTelefonos(){
        boolean hayAlguno = false;              
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].trim().isEmpty()) {
                System.out.println((i + 1) + ") " + telefono[i]);
                hayAlguno = true;               
            }
        }
        if (!hayAlguno) {                      
            System.out.println("No existen números de teléfonos en la lista");
        }
    }
}

