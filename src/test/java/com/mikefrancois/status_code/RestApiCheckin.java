package com.mikefrancois.status_code;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RestApiCheckin {

    @Test
    public void givenAtmServiceIsUp()
            throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8090/ingatm/api/cities");

        // When
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.OK.value());
    }

    @Test
    public void givenAtmServiceReturnAtmList()
            throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8090/ingatm/api/cities");

        // When
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertNotNull(httpResponse.getEntity().getContent());
    }

}
