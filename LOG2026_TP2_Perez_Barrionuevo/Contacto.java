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
    
}

//getters y setters
//nombre
public String getNombre(){ return this.nombre;}
public void setNombre(String nombre){
    if(nombre!= null){
        if(!nombre.trim().isEmpty()){
            this.nombre=nombre.toUpperCase();
        }else{
            this.nombre= "S/D";
        }
    }else{
        this.nombre= "S/D";
    }
    this.nombre=nombre.toUpperCase();
}
//localidad
public String getLocalidad(){ return this.localidad;}
public void setLocalidad(String localidad){this.localidad=localidad.toUpperCase();}
//direccion
public String getDireccion(){ return this.direccion;}
public void setDireccion(String direccion){this.direccion=direccion.toUpperCase();}

}

