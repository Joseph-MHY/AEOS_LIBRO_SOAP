package pe.edu.idat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.idat.ws.GetLibroRequest;
import pe.edu.idat.ws.GetLibroResponse;

@Endpoint
public class LibroEndPoint {

    private static final String NAMESPACE_URI = "http://idat.edu.pe/ws";

    private LibroRepository libroRepository;

    @Autowired
    public LibroEndPoint(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibroRequest")
    @ResponsePayload
    public GetLibroResponse getBook(@RequestPayload GetLibroRequest request){
        GetLibroResponse respuesta = new GetLibroResponse();
        respuesta.setLibro(libroRepository.getLibro(request.getTitulo()));
        return respuesta;
    }
}
