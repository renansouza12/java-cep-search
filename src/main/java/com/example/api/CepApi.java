package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CepApi {
    private int cepAddress; 
    private String cepUrl;
    private String json;    



public void apiHandling() throws IOException, InterruptedException{
    
        setCepUrl(String.format("http://viacep.com.br/ws/%d/json/",getCepAddress()));
    
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(getCepUrl()))
         .build();
         try{

            HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if(statusCode == 200){
             setJson(response.body());
            }
         }catch(IOException | InterruptedException e){
            throw new IOException("Request Failed");
        
         }
   }

    public int getCepAddress() {
        return cepAddress;
    }


    public void setCepAddress(int cepAddress) {
        this.cepAddress = cepAddress;
    }

    public String getCepUrl() {
        return cepUrl;
    }

    public void setCepUrl(String cepUrl) {
        this.cepUrl = cepUrl;
    }
    

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
        
}
