package com.mycompany.whatsapp;

import com.google.gson.*;
import java.util.Date;

public class Test {

    private static Usuario usuario;
    private static Date fecha = new Date();

    public static void nuevoUsuario() {
        Encriptacion e = new Encriptacion();
        String n = e.Encriptamiento("Erick"), c = e.Encriptamiento("Programacion");
        System.out.println(n + "\n" + c);
        int t = 79456545;
        boolean s = false;
        usuario = new Usuario(n, c, t, s);
    }

    public static void nuevoContacto() {
        Contactos ca = new Contactos("Gabo", 123, false);
        Mensajes m = new Mensajes();
        m.Reset("MensajesGabo");
        Contactos cj = new Contactos("Poncho", 489, false);
        m.Reset("MensajesPoncho");
        Contactos cb = new Contactos("Gabriela", 456, true);
        m.Reset("MensajesGabriela");
        Contactos cc = new Contactos("Mariana", 789, true);
        m.Reset("MensajesMariana");
        Contactos cd = new Contactos("Jade", 789, true);
        m.Reset("MensajesJade");
    }

    public static void nuevoMensajes() {
        Mensajes m = new Mensajes();
        m.Reset("MensajesJade");
        m.Reset("MensajesGabo");
        Encriptacion e = new Encriptacion();
        Mensajes m1 = new Mensajes("Erick", "MensajesJade", e.Encriptamiento("Te amooo muucho Amor mio"), fecha.toString(), true);
        Mensajes m2 = new Mensajes("Erick", "MensajesJade", e.Encriptamiento("Eres el amor de mi vida"), fecha.toString(), true);
        Mensajes m3 = new Mensajes("Erick", "MensajesGabo", e.Encriptamiento("Pasa la Tarea xd"), fecha.toString(), true);
        Mensajes m4 = new Mensajes("Erick", "MensajesGabo", e.Encriptamiento("Como estas"), fecha.toString(), true);
    }

    public static void main(String[] args) {
        //reset usuario
//        nuevoUsuario();

        //Agragar usuarios
//        usuario = new Usuario();
        //Reset Contactos
//        Contactos c = new Contactos();
//        c.Reset();
        //nuevoContactos
//        nuevoContacto();
        //nuevos Mensajes
//        nuevoMensajes();
//        Mensajes m = new Mensajes();
//        m.Reset("prueba");
//        Bot b = new Bot("Erick","hola","prueba");
//        Bot b1 = new Bot("Erick","Quieres ir hoy a comer?","prueba");
//        Bot b2 = new Bot("Erick","Crees que el profesor nos ponga buena calificación?","prueba");
        for (int i = 0; i < 10; i++) {
            int s = (int) (Math.random()*1);
            System.out.println(s);
        }
    }

}
