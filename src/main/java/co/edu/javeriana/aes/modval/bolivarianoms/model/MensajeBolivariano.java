/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.modval.bolivarianoms.model;

/**
 *
 * @author sebastianpacheco
 */
public class MensajeBolivariano {
    
    private String apellido;
    
    private String nombre;
    
    private String fechaSalida;
    
    private String numViaje;
    
    private String numSilla;
    
    private String orderId;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNumViaje() {
        return numViaje;
    }

    public void setNumViaje(String numViaje) {
        this.numViaje = numViaje;
    }

    public String getNumSilla() {
        return numSilla;
    }

    public void setNumSilla(String numSilla) {
        this.numSilla = numSilla;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
}
