package fr.pantheonsorbonne.ufr27.miage.exception;

public class NotServedFloorException extends Throwable {
    public NotServedFloorException(){
        super("l'étage selectionné n'est pas desservi par cet ascenseur");
    }
}
