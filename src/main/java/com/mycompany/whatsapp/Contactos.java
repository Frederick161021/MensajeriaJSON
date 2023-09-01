package com.mycompany.whatsapp;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.*;
import java.util.LinkedList;

public class Contactos {

    public JsonObject gsonObj;
    private JSONArray Contactos = new JSONArray();
    private JSONObject listaContactos = new JSONObject();
    private JSONObject nuevoContacto = new JSONObject();
    private int telefono = 0, numeroContactos = 0;
    private String nombreContacto = "", idMensajes = "";
    private boolean sexo = false;

    public Contactos() {}
    
    public Contactos(String nombre) {
        BuscarContactoJson(nombre);
    }

    public Contactos(String nombreContacto, int telefono, boolean sexo) {
        getNumContactosJson();
        setNombreContacto(nombreContacto);
        setIdMensajes("Mensajes" + nombreContacto);
        setTelefono(telefono);
        setSexo(sexo);
        nuevoContacto();
    }

    public void Reset() {
        listaContactos.put("numeroContactos", 0);
        try (FileWriter fileUsuario = new FileWriter("Contactos.json")) {
            fileUsuario.write(listaContactos.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNumContactosJson() {
        listaContactos.put("numeroContactos", numeroContactos);
    }

    public void getNumContactosJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("Contactos.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject contacto = (JSONObject) obj;
            setNumeroContactos(Integer.parseInt(String.valueOf(contacto.get("numeroContactos"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nuevoContacto() {
        numeroContactos++;
        nuevoContacto.put("nombreContacto", nombreContacto);
        nuevoContacto.put("Telefono", telefono);
        nuevoContacto.put("Sexo", sexo);
        nuevoContacto.put("idMensajes", idMensajes);
        agregarContacto();
    }

    private void getContactosJson() {
        JSONParser jsonParser = new JSONParser();
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader("Contactos.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject contacto = (JSONObject) obj;
            String arrayContactos = String.valueOf(contacto.get("listaContactos"));
            JsonArray vContactos = parser.parse(arrayContactos).getAsJsonArray();
            for (JsonElement Obj : vContactos) {
                gsonObj = Obj.getAsJsonObject();
                JSONObject transfomador = new JSONObject();
                transfomador.put("nombreContacto", gsonObj.get("nombreContacto"));
                transfomador.put("Telefono", gsonObj.get("Telefono"));
                transfomador.put("Sexo", gsonObj.get("Sexo"));
                transfomador.put("idMensajes", gsonObj.get("idMensajes"));
                Contactos.add(transfomador);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList getNombreContactosJson() {
        LinkedList nombres = new LinkedList();
        JSONParser jsonParser = new JSONParser();
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader("Contactos.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject contacto = (JSONObject) obj;
            String arrayContactos = String.valueOf(contacto.get("listaContactos"));
            JsonArray vContactos = parser.parse(arrayContactos).getAsJsonArray();
            for (JsonElement Obj : vContactos) {
                gsonObj = Obj.getAsJsonObject();
                nombres.add(gsonObj.get("nombreContacto"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombres;
    }

    public void BuscarContactoJson(String nombre) {
        JSONObject contactoBuscado = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader("Contactos.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject contacto = (JSONObject) obj;
            String arrayContactos = String.valueOf(contacto.get("listaContactos"));
            JsonArray vContactos = parser.parse(arrayContactos).getAsJsonArray();
            for (JsonElement Obj : vContactos) {
                gsonObj = Obj.getAsJsonObject();
                if (nombre.equals(String.valueOf(gsonObj.get("nombreContacto")))) {
                    setNombreContacto(String.valueOf(gsonObj.get("nombreContacto")));
                    setTelefono(Integer.parseInt(String.valueOf(gsonObj.get("Telefono"))));
                    setSexo(Boolean.parseBoolean(String.valueOf(gsonObj.get("Sexo"))));
                    setIdMensajes(String.valueOf(gsonObj.get("idMensajes")));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void agregarContacto() {
        getContactosJson();
        Contactos.add(nuevoContacto);
        setNumContactosJson();
        listaContactos.put("listaContactos", Contactos);
        try (FileWriter fileUsuario = new FileWriter("Contactos.json")) {
            fileUsuario.write(listaContactos.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumeroContactos() {
        return numeroContactos;
    }

    public void setNumeroContactos(int n) {
        this.numeroContactos = n;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getIdMensajes() {
        return idMensajes;
    }

    public void setIdMensajes(String idMensajes) {
        this.idMensajes = idMensajes;
    }

    public String toString() {
        String Sexo;
        if (sexo) {
            Sexo = "Femenino";
        } else {
            Sexo = "Masculino";
        }
        return "La informacion del Contacto es:\nNombre: " + nombreContacto + "\nTelefono: " + telefono + "\nSexo: " + Sexo;
    }

}
