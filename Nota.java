/**
 * Representa una nota de la agenda con titulo, texto, mes, dia
 * con el contacto al que esta asociada
 * 
 * @author Perez Ignacio
 * @author Barrionuevo Francisco
 * @version 1.0
 */
public class Nota{
    //Atributos 
    private String titulo;
    private String texto;
    private int mes;
    private int dia;
    private Contacto contacto;
    
    //Getters y Setters
    /**
     * Devuelve el titulo de la nota
     * @return el titulo de la nota
     */
    public String getTitulo(){ return this.titulo;}
    /**
     * Asigna el titulo de la nota
     * @param titulo el titulo de la nota
     */
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    
    /**
     * Devuelve el texto de la nota
     * @return el texto de la nota
     */
    public String getTexto(){ return this.texto;}
    /**
     * Asigna el texto de la nota
     * @param texto el texto de la nota
     */
    public void setTexto(String texto){
        this.texto=texto;
    }
    
    /**
     * Devuelve el mes de la nota
     * @return el mes de la nota
     */
    public int getMes(){ return this.mes;}
    /**
     * Asigna el mes de la nota
     * @param mes el mes de la nota
     */
    public void setMes(int mes){
        this.mes=mes;
    }
    
    /**
     * Devuelve el dia de la nota
     * @return el dia de la nota
     */
    public int getDia(){ return this.dia;}
    /**
     * Asigna el dia de la nota
     * @param dia el dia de la nota
     */
    public void setDia(int dia){
        this.dia=dia;
    }
    
    /**
     * Devuelve el contacto de la nota
     * @return el contacto de la nota
     */
    public Contacto getContacto(){return this.contacto;}
    /**
     * Asigna el titulo de la nota
     * @param contacto el contacto de la nota
     */
    public void setContacto(Contacto contacto){
        this.contacto=contacto;
    }
}