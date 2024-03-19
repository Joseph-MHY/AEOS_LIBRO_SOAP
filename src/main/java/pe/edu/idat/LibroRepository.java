package pe.edu.idat;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import pe.edu.idat.ws.Libro;

import java.util.HashMap;
import java.util.Map;

@Component
public class LibroRepository {

    private static final Map<String, Libro> libros = new HashMap<>();

    @PostConstruct
    public void iniData(){
        // Agregar tres libros de ejemplo al inicializar
        Libro libro1 = new Libro();
        libro1.setTitulo("El nombre del viento");
        libro1.setAutor("Patrick Rothfuss");
        libro1.setAnioPublicacion(2007);
        libro1.setGenero("Fantasía");
        libros.put(libro1.getTitulo(), libro1);

        Libro libro2 = new Libro();
        libro2.setTitulo("Cien años de soledad");
        libro2.setAutor("Gabriel García Márquez");
        libro2.setAnioPublicacion(1967);
        libro2.setGenero("Realismo mágico");
        libros.put(libro2.getTitulo(), libro2);

        Libro libro3 = new Libro();
        libro3.setTitulo("Harry Potter y la piedra filosofal");
        libro3.setAutor("J.K. Rowling");
        libro3.setAnioPublicacion(1997);
        libro3.setGenero("Fantasía");
        libros.put(libro3.getTitulo(), libro3);
    }

    public Libro getLibro(String titulo){
        Assert.notNull(titulo,"El nombre del país debe ser diferente de nulo");
        return libros.get(titulo);
    }
}
