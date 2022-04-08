package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{
    public PersistenceException(String msg,Exception persistenceException){
        super(msg,persistenceException);
    }

    public PersistenceException(String msg){
        super(msg);
    }
}
