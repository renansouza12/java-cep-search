package com.example;

import java.io.IOException;
import java.util.Scanner;

import com.example.models.CepResultModel;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var c = new CepResultModel();
        var sc = new Scanner(System.in);

        System.out.println("Enter your CEP:");
        c.setCep(sc.nextInt());
        c.getResult();
        sc.close();

    }   

}