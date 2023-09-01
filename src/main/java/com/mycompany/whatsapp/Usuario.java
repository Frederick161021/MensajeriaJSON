package com.mycompany.whatsapp;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Usuario {
    private Encriptacion e = new Encriptacion();
    private JSONObject usuario = new JSONObject();
    private String nombreUsuario = "", contraseña = "";
    private int telefono = 0;
    private boolean sexo = false;

    public Usuario() {
        getUsuario();
    }

    public Usuario(String nombreUsuario, String contraseña, int telefono, boolean sexo) {
        setNombreUsuario(nombreUsuario);
        setTelefono(telefono);
        setContraseña(contraseña);
        setSexo(sexo);
        setUsuario();
    }

    private void getUsuario() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("Usuario.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject usuario = (JSONObject) obj;
            setNombreUsuario(String.valueOf(usuario.get("nombreUsuario")));
            setContraseña(String.valueOf(usuario.get("Contraseña")));
            setTelefono(Integer.parseInt(String.valueOf(usuario.get("Telefono"))));
            setSexo(Boolean.parseBoolean(String.valueOf(usuario.get("Sexo"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUsuario() {
        usuario.put("nombreUsuario", nombreUsuario);
        usuario.put("Telefono", telefono);
        usuario.put("Contraseña", contraseña);
        usuario.put("Sexo", sexo);
        try (FileWriter fileUsuario = new FileWriter("Usuario.json")) {
            fileUsuario.write(usuario.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNombreUsuario() {
        return e.Desencriptamiento(nombreUsuario);
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void setNuevoNombreUsuario(String nombreUsuario){
        setNombreUsuario(nombreUsuario);
        usuario.put("nombreUsuario", nombreUsuario);
        usuario.put("Telefono", telefono);
        usuario.put("Contraseña", contraseña);
        usuario.put("Sexo", sexo);
        try (FileWriter fileUsuario = new FileWriter("Usuario.json")) {
            fileUsuario.write(usuario.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getContraseña() {
        Encriptacion e = new Encriptacion();
        contraseña = e.Desencriptamiento(contraseña);
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void setNuevaContraseña(String contraseña){
        setContraseña(contraseña);
        usuario.put("nombreUsuario", nombreUsuario);
        usuario.put("Telefono", telefono);
        usuario.put("Contraseña", contraseña);
        usuario.put("Sexo", sexo);
        try (FileWriter fileUsuario = new FileWriter("Usuario.json")) {
            fileUsuario.write(usuario.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void setNuevoTelefono(int telefono){
        setTelefono(telefono);
        usuario.put("nombreUsuario", nombreUsuario);
        usuario.put("Telefono", telefono);
        usuario.put("Contraseña", contraseña);
        usuario.put("Sexo", sexo);
        try (FileWriter fileUsuario = new FileWriter("Usuario.json")) {
            fileUsuario.write(usuario.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    
    public void setNuevoSexo(boolean sexo){
        setSexo(sexo);
        usuario.put("nombreUsuario", nombreUsuario);
        usuario.put("Telefono", telefono);
        usuario.put("Contraseña", contraseña);
        usuario.put("Sexo", sexo);
        try (FileWriter fileUsuario = new FileWriter("Usuario.json")) {
            fileUsuario.write(usuario.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String Sexo;
        if (sexo) {
            Sexo = "Femenino";
        } else {
            Sexo = "Masculino";
        }
        return "Informacion del Usuario:\nNombre del Usuario: " + getNombreUsuario() + "\nTelefono: " + getTelefono() + "\nSexo: " + Sexo;
    }
}
