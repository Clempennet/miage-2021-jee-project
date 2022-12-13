package fr.pantheonsorbonne.ufr27.miage.exception;

public class NoAscenseurAvailableException extends Throwable {
    public NoAscenseurAvailableException(){
        super("Aucun ascenseur n'est disponible, Hors Service");
    }
}
