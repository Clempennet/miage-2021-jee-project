package fr.pantheonsorbonne.ufr27.miage.camel;

import javax.transaction.Transactional;

public interface AscenseurGateway {
    void sendEtageActuelR(int etage) throws InterruptedException;

    void sendEtageActuelJ(int etage) throws InterruptedException;

    void sendEtageActuelV(int etage) throws InterruptedException;

    void AscenseurIsOpen(int idAscenseur);

    void entrer(int id);

    @Transactional
    void fin(int idAscenseur);

    void sortir(int etage);
}
