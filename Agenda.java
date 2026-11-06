import java.util.ArrayList;
import java.util.HashMap;
/**
 * Representa una agenda formada por una lista de notas y un mapa de contactos.
 * 
 * @author Perez Ignacio
 * @author Barrionuevo Francisco
 * @version 1.0
 */
public class Agenda{
    private String nombre;
    private ArrayList<Nota> notas;
    private HashMap<String, Contacto> contactos;
    /**
     * Constructor: Guarda el nombre y crea la lista de notas y el mapa de contactos, vacios.
     * @param nombre el nombre de la agenda.
     */
    public Agenda(String nombre){
        this.nombre = nombre;
        notas = new ArrayList<>();
        contactos = new HashMap<>();
    }
    
    /**
     * Registra un contacto en el mapa de contactos, usando su nombre como clave.
     * @param contacto el contacto a agregar.
     */
    public void agregarContacto(Contacto contacto){
        String clave = contacto.getNombre();
    
        if(contactos.containsKey(clave)){
            System.out.println("El contacto " + clave + " ya existe en la agenda");
        } else {
            contactos.put(clave, contacto);
        }
    }
    
    /**
     * Agrega una nota a la lista de notas y registra su contacto en el mapa si aun no está.
     * @param nota la nota a agregar.
     */
    public void agregarNota(Nota nota){
        notas.add(nota);
        String clave = nota.getContacto().getNombre();
        if(!contactos.containsKey(clave)){
            agregarContacto(nota.getContacto());
        }
    }
    
    /**
     * Muestra todos los contactos registrados en la agenda.
     */
    public void listarContactos(){
        if(contactos.isEmpty()){
            System.out.println("La agenda no tiene contactos");
            return;
        }
        for(Contacto c : contactos.values()){
            System.out.println("Contacto: " + c.getNombre() + "  Localidad: " + c.getLocalidad() + "  Direccion: " + c.getDireccion());
            System.out.println("  Telefonos:");
            c.listarTelefonos();
        }
    }
    
    /**
     * Privado. Indica si el contacto está asociado a al menos una nota de la agenda.
     * @param contacto el contacto a buscar en las notas.
     * @return true si al menos una nota tiene ese contacto, sino false.
     */
    private boolean tieneNotas(Contacto contacto){
        for (Nota n : notas){
            if(n.getContacto() == contacto){
            return true;
            }
        }
        return false;
    }
    
    /**
     * Muestra solo los contactos que tienen una nota asociada.
     */
    public void listarContactosConNotas(){
        boolean hayAlguno = false;
        
        for(Contacto c : contactos.values()){
            if(tieneNotas(c)){
                System.out.println("Contacto: " + c.getNombre() + "  Localidad: " + c.getLocalidad() + "  Direccion: " + c.getDireccion());
                System.out.println("  Telefonos:");
                c.listarTelefonos();
                hayAlguno = true;
            }
        }
        if(!hayAlguno){
            System.out.println("No hay contactos con notas");
        }
    }
    
    /**
     * Muestra solo los contactos que no tienen una nota asociada.
     */
    public void listarContactosSinNotas(){
        boolean hayAlguno = false;
        
        for(Contacto c : contactos.values()){
            if(!tieneNotas(c)){
                System.out.println("Contacto: " + c.getNombre() + "  Localidad: " + c.getLocalidad() + "  Direccion: " + c.getDireccion());
                System.out.println("  Telefonos:");
                c.listarTelefonos();
                hayAlguno = true;
            }
        }
        if(!hayAlguno){
            System.out.println("No hay contactos sin notas");
        }
    }
    
    /**
     * Quita del mapa el contacto indicado. Siempre que no tenga notas asociadas.
     * @param nombre el nombre del contacto a eliminar.
     */
    public void eliminarContacto(String nombre){
        String clave = nombre.toUpperCase();
        
        if (!contactos.containsKey(clave)){
            System.out.println("El contacto " + nombre + " no se encuentra");
            return;
        }
        
        Contacto c = contactos.get(clave);
        if(tieneNotas(c)){
            System.out.println("El contacto " + nombre + " tiene notas asociadas y no se puede eliminar");
            return;
        }
        
        contactos.remove(clave);
    }
    
    /**
     * Muestra todas las notas de la agenda con el formato indicado mas abajo.
     */
    public void listarNotas(){
        if(notas.isEmpty()){
            System.out.println("La agenda no tiene notas");
            return;
        }
        
        System.out.println("*******************************************************************************************************************");
        System.out.println("Nombre: " + this.nombre);
        
        for(Nota n: notas){
            System.out.println("  Titulo: " + n.getTitulo() + "  Texto: " + n.getTexto() + "  Mes: " + n.getMes() + "  Dia: " + n.getDia());
            System.out.println("    Contacto: " + n.getContacto().getNombre() + "  Localidad: " + n.getContacto().getLocalidad() + "  Direccion: " + n.getContacto().getDireccion());
            System.out.println("    Telefonos: ");
            n.getContacto().listarTelefonos();
        }
        System.out.println("*******************************************************************************************************************"); 
    }
}        