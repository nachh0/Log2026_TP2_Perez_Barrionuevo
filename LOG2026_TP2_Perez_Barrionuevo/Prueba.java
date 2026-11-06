public class Prueba{
    public static void main(String[] args){
        Contacto c1 = new Contacto("Juan Perez", "Santa Fe", "25 de Mayo 1111", "0342-4567891");
        Contacto c2 = new Contacto("Ana Gomez", "Rosario", "Cordoba 500", "0341-4567892");
        Contacto c3 = new Contacto("Carlos Lopez", "Santo Tome", "Mitre 200", "0342-4567893");
        Contacto c4 = new Contacto("Maria Diaz", "Parana", "Urquiza 350", "0343-4567894");
        Contacto c5 = new Contacto("Pedro Fernandez", "Santa Fe", "San Martin 1200", "0342-4567895");
        
        c1.agregarTelefono("0342", 4556677);
        c1.agregarTelefono("0341", 4112233);
        c1.agregarTelefono("0343", 4998877);
        c1.agregarTelefono("011", 4321432);
        
        c1.listarTelefonos();
        
        Nota n1 = new Nota();
        n1.setTitulo("reunion inicial");
        n1.setTexto("especificacion de requerimientos");
        n1.setMes(4);
        n1.setDia(3);
        n1.setContacto(c1);
        
        Nota n2 = new Nota();
        n2.setTitulo("bases de datos");
        n2.setTexto("definicion de claves");
        n2.setMes(5);
        n2.setDia(4);
        n2.setContacto(c2);
        
        Nota n3 = new Nota();
        n3.setTitulo("documentacion");
        n3.setTexto("entrega de documentacion formal");
        n3.setMes(6);
        n3.setDia(5);
        n3.setContacto(c3);
        
        Nota n4 = new Nota();
        n4.setTitulo("carga de datos");
        n4.setTexto("carga y migrado de datos");
        n4.setMes(7);
        n4.setDia(6);
        n4.setContacto(c4);
        
        Agenda agenda = new Agenda("agenda 2026");
        
        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);
        agenda.agregarContacto(c3);
        agenda.agregarContacto(c4);
        agenda.agregarContacto(c5);
        
        agenda.agregarNota(n1);
        agenda.agregarNota(n2);
        agenda.agregarNota(n3);
        agenda.agregarNota(n4);
        
        agenda.listarNotas();
        
        agenda.listarContactos();
        
        agenda.listarContactosConNotas();
        
        agenda.listarContactosSinNotas();
        
        agenda.eliminarContacto("Juan Perez");
        
        agenda.eliminarContacto("Pedro Fernandez");
        
        agenda.listarContactos();
        
    }
}