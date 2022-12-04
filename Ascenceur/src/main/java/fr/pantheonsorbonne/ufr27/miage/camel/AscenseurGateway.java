package fr.pantheonsorbonne.ufr27.miage.camel;

public interface AscenseurGateway {
    void sendEtageActuelR(int etage);

    void sendEtageActuelJ(int etage);

    void sendEtageActuelV(int etage);

    void AscenseurIsOpen(int idAscenseur);

}
