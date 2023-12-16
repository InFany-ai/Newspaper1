package shop.service.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JSONMessageBodyReader<T> implements MessageBodyReader<T> {

    ObjectMapper mapper;

    public JSONMessageBodyReader() throws JAXBException {
        mapper = new ObjectMapper();
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                      MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
        throws IOException, WebApplicationException {

        T t = mapper.readValue(entityStream, type);
        return t;
    }
}
