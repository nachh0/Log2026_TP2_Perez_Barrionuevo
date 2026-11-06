import java.util.ArrayList;
import java.util.HashMap;
public class Agenda{
    private String nombre;
    private ArrayList<Nota> notas;
    private HashMap<String, Contacto> contactos;
    
    public Agenda(String nombre){
        this.nombre = nombre;
        notas = new ArrayList<>();
        contactos = new HashMap<>();
    }
    
    public void agregarContacto(Contacto contacto){
        String clave = contacto.getNombre();
    
        if(contactos.containsKey(clave)){
            System.out.println("El contacto " + clave + " ya existe en la agenda");
        } else {
            contactos.put(clave, contacto);
        }
    }
    
    public void agregarNota(Nota nota){
        notas.add(nota);
        String clave = nota.getContacto().getNombre();
        if(!contactos.containsKey(clave)){
            agregarContacto(nota.getContacto());
        }
    }
    
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
    
    private boolean tieneNotas(Contacto contacto){
        for (Nota n : notas){
            if(n.getContacto() == contacto){
            return true;
            }
        }
        return false;
    }
    
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