package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

public interface AscenseurService {
    public Ascenseur createNewAscenseur(int id, int etage, boolean isGoingUp, boolean isInError, boolean isDoorOpen);
    public void moveToEtage(Ascenseur a,int etage);

    public void openDoor(Ascenseur a);

    public void closeDoor(Ascenseur a);

    public void goDown(Ascenseur a);

    public  void goUp(Ascenseur a);

    public  void move(int idAscenseur, int etage);

    public Ascenseur getAscenseur(int id);
}
