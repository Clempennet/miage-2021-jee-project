package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.GrpAscenseur;
import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.model.Usager;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;
@ApplicationScoped
public class AppelerAscenseurImpl implements AppelerAscenseur {

    public void alert(){
        System.out.println("ascenseur hs, nous appelons le technicien");
    }
}
