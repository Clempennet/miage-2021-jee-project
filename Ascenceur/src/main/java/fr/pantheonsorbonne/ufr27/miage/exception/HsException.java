package fr.pantheonsorbonne.ufr27.miage.exception;

public class HsException extends Throwable{

    public HsException(int ascId){
        super ("Ascenseur Hors Service");
    }
}
