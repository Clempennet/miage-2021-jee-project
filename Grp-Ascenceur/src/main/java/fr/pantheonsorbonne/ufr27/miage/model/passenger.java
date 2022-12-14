package fr.pantheonsorbonne.ufr27.miage.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@Table(name = "passenger")
@Entity
public class passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;


    @Column(name = "name", nullable = false)
    String name;
    @Column()
    int idAscenseur;

    public passenger() {

    }

    public int getIdAscenseur() {
        return idAscenseur;
    }

    public void setIdAscenseur(int idAscenseur) {
        this.idAscenseur = idAscenseur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
