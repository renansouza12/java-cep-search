package com.example.models;

import java.io.IOException;
import com.example.api.CepApi;
import com.google.gson.Gson;

public class CepResultModel {
    private int cep;

    CepApi cepResult = new CepApi();
    
   public void getResult() throws IOException, InterruptedException {
        var g = new Gson();       

        if (cep <= 0) {
            System.out.println("Invalid cep value!!!");
            return;
        }

        cepResult.setCepAddress(getCep());
        cepResult.apiHandling();
        
        CepRecord cr = g.fromJson(cepResult.getJson(), CepRecord.class);
        
        System.out.println(cr);
   }
   
   public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

}

