package com.mycompany.whatsapp;

import java.util.Date;

public class Bot {
    private String contacto="", mensaje="", idMensaje="";
    private int numMensaje;
    public Bot(){}
    
    public Bot(String contacto,String mensaje,String idMensaje){
        setContacto(contacto);
        setMensaje(mensaje);
        setIdMensaje(idMensaje);
        enviarMensaje();
    }
    
    private String Respuesta(){
        if (mensaje.equalsIgnoreCase("hola")) {
            return "Hola como estas?";
        }
        if (mensaje.equalsIgnoreCase("bien")) {
            return "Me alegro mucho :)";
        }
        if (mensaje.equalsIgnoreCase("mal")) {
            return "Oh!, que mal espero que pronto todo mejore :(";
        }
        if (mensaje.equalsIgnoreCase("bien y tu?")) {
            return "Pues, me corto mi pareje, se murio mi perro, repobe todo pero sigo con vida";
        }
        if (mensaje.equalsIgnoreCase("En que ciudad estas?")) {
            return "Estoy en Saltillo";
        }
        if (mensaje.equalsIgnoreCase("Quieres ir hoy a comer?")) {
            return "Hoy no puedo, ni mañnana, ni ningun dia. Disculpa";
        }
        if (mensaje.equalsIgnoreCase("Cual es tu estacion del año favorita?")) {
            return "Me gusta bastante el otoño";
        }
        if (mensaje.equalsIgnoreCase("Cual es tu deporte favorito?")) {
            return "Me gusta mucho el bascketball";
        }
        if (mensaje.equalsIgnoreCase("Crees que el profesor nos ponga buena calificación?")) {
            return "Claro que si";
        }
        if (mensaje.equalsIgnoreCase("Cuentame un chiste")) {
            return "¿Qué hace Batman en el Aeropuerto?, Batijuana.";
        }
        if (mensaje.equalsIgnoreCase("Qué hiciste el fin de semana?")) {
            return "Realmente nada interesante, solo reserve un viaje a colombia";
        }
        if (mensaje.equalsIgnoreCase("Eso me parece bastante interesante")) {
            return "Un poco, pero no mucho";
        }
        if (mensaje.equalsIgnoreCase("Ojala algun dia pueda ir tambien")) {
            return "A mi no me gusta, hace mucho calor";
        }
        if (mensaje.equalsIgnoreCase("Ya veo")) {
            return "Pero un dia hay que ir de verdad";
        }
        if (mensaje.equalsIgnoreCase("adios")) {
            return "Adios espero que pronto volvamos a ahablar";
        }
        if (mensaje.equalsIgnoreCase("Como te fue en el examen?")) {
            return "Reprobe pero hay salud xd";
        }
        if (mensaje.equalsIgnoreCase("tambien me fue mal")) {
            return "por que dices?";
        }
        if (mensaje.equalsIgnoreCase("no estudie")) {
            return "quizas es por eso, en el proximo te ira mejor";
        }
        if (mensaje.equalsIgnoreCase("gracias")) {
            return "cuando ocupes ayuda aqui estoy";
        }
        if (mensaje.equalsIgnoreCase("Cual es tu comida favorita?")) {
            return "A mi me gusta mucho la pizza";
        }
        if (mensaje.equalsIgnoreCase("Cual es tu materia favorita?")) {
            return "Mi materia favorita es Algoritmos de Ordenamientos y Busqueda";
        }
        if (mensaje.equalsIgnoreCase("Cual es tu banda favorita?")) {
            return "Coldplay es mi banda favorita en todo el tiempo";
        }
        if (mensaje.equalsIgnoreCase("Te gusta viajar?")) {
            return "Claro, mi destino favorito es siempre es Nueva York";
        }
        if (mensaje.equalsIgnoreCase("si pudieras a donde irias de intercambio?")) {
            return "Al reino de los cielos";
        }
        if (mensaje.equalsIgnoreCase("que")) {
            return "so";
        }
        return "Perdona pero ya me tengo que ir, nos vemos luego";
    
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }
    
    public Mensajes enviarMensaje(){
        Encriptacion e = new Encriptacion();
        Date fecha = new Date();
        Mensajes m = new Mensajes(contacto,idMensaje,e.Encriptamiento(Respuesta()),fecha.toString(), true);
        return m;
    }
}
