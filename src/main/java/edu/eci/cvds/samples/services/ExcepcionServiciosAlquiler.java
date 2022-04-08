package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
    public ExcepcionServiciosAlquiler(String msg,Exception serviceException){
        super(msg,serviceException);
    }
    public ExcepcionServiciosAlquiler(String msg){
        super(msg);
    }
}
