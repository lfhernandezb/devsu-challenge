package com.example.devsutestcuentamovimiento.service;

import com.example.devsutestcuentamovimiento.error_handling.RestErrorHandler;
import com.example.devsutestcuentamovimiento.exception.MissingConfigurationValueException;
//import com.example.devsutestcuentamovimiento.pojo.Cliente;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

;

@Service
public class ClienteService {

    String serviceUrl = "http://CLIENTE-PERSONA-SERVICE";

    private static final Logger logger = Logger.getLogger(ClienteService.class.getName());

    @Autowired
    protected RestTemplate restTemplate;

    //@Value("${clienteService.url}")
    //private String clienteServiceUrl;

    /*
    public ClienteService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }
    */

    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory().getClass());
    }

    public Cliente getById(long clientId) { //throws InterruptedException, RestClientException, MissingConfigurationValueException {
        /*if (clienteServiceUrl.isEmpty()) {
            throw new MissingConfigurationValueException("No existe la URL del servicio de clientes");
        }*/

        String url = serviceUrl + "/api/clientes/" + clientId;

        try {
            //return restTemplate.getForObject(url, Cliente.class);
            return restTemplate
                    .exchange(url
                            , HttpMethod.GET
                            , null
                            , new ParameterizedTypeReference<Cliente>() {
                            }, clientId).getBody();
        } catch (Exception e) {
            logger.severe(e.getClass() + ": " + e.getLocalizedMessage());
            return null;
        }

    }

    public Cliente getByNombre(String nombreCliente) { // throws InterruptedException, RestClientException, MissingConfigurationValueException {

        logger.info("called getByNombre");
        /*if (clienteServiceUrl.isEmpty()) {
            throw new MissingConfigurationValueException("No existe la URL del servicio de clientes");
        }*/

        String url = serviceUrl + "/api/clientes/param?nombre=" + nombreCliente;

        try {
            //return restTemplate.getForObject(url, Cliente.class);
            return restTemplate
                    .exchange(url
                            , HttpMethod.GET
                            , null
                            , new ParameterizedTypeReference<Cliente>() {
                            }, nombreCliente).getBody();

        } catch (Exception e) {
            logger.severe(e.getClass() + ": " + e.getLocalizedMessage());
            return null;
        }

    }


    /*
    @Async
    public CompletableFuture<Cliente> getById(long clientId) { //throws InterruptedException, RestClientException, MissingConfigurationValueException {
        if (clienteServiceUrl.isEmpty()) {
            throw new MissingConfigurationValueException("No existe la URL del servicio de clientes");
        }

        String url = clienteServiceUrl + "/param?clienteId=" + clientId;

        Cliente cliente = restTemplate.getForObject(url, Cliente.class);

        return CompletableFuture.completedFuture(cliente);

    }

    @Async
    public CompletableFuture<Cliente> getByNombre(String nombreCliente) { // throws InterruptedException, RestClientException, MissingConfigurationValueException {

        logger.info("called getByNombre");
        if (clienteServiceUrl.isEmpty()) {
            throw new MissingConfigurationValueException("No existe la URL del servicio de clientes");
        }

        String url = clienteServiceUrl + "/param?nombre=" + nombreCliente;

        Cliente cliente = restTemplate.getForObject(url, Cliente.class);

        logger.info("after restTemplate.getForObject(url, Cliente.class)");

        return CompletableFuture.completedFuture(cliente);

    }
     */
}
