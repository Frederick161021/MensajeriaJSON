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

public class Mensajes {
    public JsonObject gsonObj;
    private LinkedList<String> mensajes = new LinkedList<String>();
    private JSONArray Mensajes = new JSONArray();
    private JSONObject listaMensajes = new JSONObject();
    private JSONObject nuevoMensaje = new JSONObject();
    private int numeroMensaje = 0, numeroMensajes = 0;
    private String Mensaje = "", idMensajes = "", fecha = "",remitente = "";
    private boolean visto = false;
    
    public Mensajes(){}
    
    public Mensajes(String idMensajes){
        mensajes.clear();
        this.idMensajes = idMensajes;
    }
    
    public Mensajes(String remitente,String idMensajes,String Mensaje,String fecha, boolean visto){
        setIdMensajes(idMensajes);
        setMensaje(Mensaje);
        setFecha(fecha);
        setVisto(visto);
        setRemitente(remitente);
        getNumMensajesJson();
        setNumeroMensaje(numeroMensajes);
        nuevoMensaje();
    }
    
    public void Reset(String idMensajes) {
        listaMensajes.put("numeroMensajes", 0);
        try (FileWriter fileMensaje = new FileWriter(idMensajes+".json")) {
            fileMensaje.write(listaMensajes.toJSONString());
            fileMensaje.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void setNumMensajesJson() {
        listaMensajes.put("numeroMensajes", numeroMensajes);
    }

    public void getNumMensajesJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(idMensajes+".json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject contacto = (JSONObject) obj;
            setNumeroMensajes(Integer.parseInt(String.valueOf(contacto.get("numeroMensajes"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nuevoMensaje() {
        numeroMensajes++;
        nuevoMensaje.put("Mensaje", Mensaje);
        nuevoMensaje.put("Remitente", remitente);
        nuevoMensaje.put("Fecha", fecha);
        nuevoMensaje.put("numeroMensaje", numeroMensaje);
        nuevoMensaje.put("Visto", visto);
        agregarMensaje();
    }

    private void getMensajesJson() {
        JSONParser jsonParser = new JSONParser();
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader(idMensajes+".json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject contacto = (JSONObject) obj;
            String arrayContactos = String.valueOf(contacto.get("listaMensajes"));
            JsonArray vContactos = parser.parse(arrayContactos).getAsJsonArray();
            for (JsonElement Obj : vContactos) {
                gsonObj = Obj.getAsJsonObject();
                JSONObject transfomador = new JSONObject();
                transfomador.put("Mensaje", gsonObj.get("Mensaje"));
                transfomador.put("Remitente", gsonObj.get("Remitente"));
                transfomador.put("Fecha", gsonObj.get("Fecha"));
                transfomador.put("numeroMensaje", gsonObj.get("numeroMensaje"));
                transfomador.put("Visto", gsonObj.get("Visto"));
                Mensajes.add(transfomador);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList getListaMensajesJson() {
        JSONParser jsonParser = new JSONParser();
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader(idMensajes+".json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject mensaje = (JSONObject) obj;
            String arrayMensajes = String.valueOf(mensaje.get("listaMensajes"));
            JsonArray vMensajes = parser.parse(arrayMensajes).getAsJsonArray();
            for (JsonElement Obj : vMensajes) {
                JsonObject gsonObj = new JsonObject();
                gsonObj = Obj.getAsJsonObject();
                setMensaje(String.valueOf(gsonObj.get("Mensaje")));
                setRemitente(String.valueOf(gsonObj.get("Remitente")));
                setFecha(String.valueOf(gsonObj.get("Fecha")));
                this.numeroMensaje = (Integer.parseInt(String.valueOf(gsonObj.get("numeroMensaje"))));
                setVisto(Boolean.parseBoolean(String.valueOf(gsonObj.get("Visto"))));
//                System.out.println(toString());
                mensajes.add(toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mensajes;
    }

    private void agregarMensaje() {
        getMensajesJson();
        Mensajes.add(nuevoMensaje);
        setNumMensajesJson();
        listaMensajes.put("listaMensajes", Mensajes);
        try (FileWriter fileUsuario = new FileWriter(idMensajes+".json")) {
            fileUsuario.write(listaMensajes.toJSONString());
            fileUsuario.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumeroMensaje() {
        return numeroMensaje;
    }

    public void setNumeroMensaje(int n) {
        this.numeroMensaje = n+1;
    }

    public int getNumeroMensajes() {
        return numeroMensajes;
    }

    public void setNumeroMensajes(int numeroMensajes) {
        this.numeroMensajes = numeroMensajes;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getIdMensajes() {
        return idMensajes;
    }

    public void setIdMensajes(String idMensajes) {
        this.idMensajes = idMensajes;
    }

    public boolean getVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String toString(){
        Encriptacion e = new Encriptacion();
        return numeroMensaje+".- "+remitente+":\n"+e.Desencriptamiento(Mensaje)+"\nFecha: "+fecha+ " Visto: "+visto;
    }
}
