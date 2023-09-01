package com.mycompany.whatsapp;

public class Encriptacion {
    
    public Encriptacion(){}
    
    public String Encriptamiento(String mensaje) {
        char array[] = mensaje.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (array[i] + (char) 5);
        }
        String encriptado = String.valueOf(array);
        return encriptado;
    }
    
    public String Desencriptamiento(String encriptado){
        char arrayD[] = encriptado.toCharArray();
        for (int i = 0; i < arrayD.length; i++) {
            arrayD[i] = (char) (arrayD[i] - (char) 5);
        }
        String desencriptado = String.valueOf(arrayD);
        return desencriptado;
    }
}
