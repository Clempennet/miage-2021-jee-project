package fr.pantheonsorbonne.ufr27.miage.camel;

import javax.transaction.Transactional;
import java.util.List;

public interface AscenseurGateway {
    void sendEtageActuelR(int etage) throws InterruptedException;

    void sendEtageActuelJ(int etage) throws InterruptedException;

    void sendEtageActuelV(int etage) throws InterruptedException;

    void AscenseurIsOpen(int idAscenseur);

    void entrer(int id);

    @Transactional
    void fin(int idAscenseur);

    void sortir(int etage);
    @Transactional
    void getGroup(List l);

    void porte(int id);

    void getAscenseur(List<Integer> l);

    void error(int id);
}
