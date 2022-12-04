package fr.pantheonsorbonne.ufr27.miage.cli;

import fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.resource.GrpAscenseurService;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine.Command;



import javax.inject.Inject;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class Main implements Runnable {

    TextTerminal<?> terminal;

    @Inject
    grpAscenseurGateway grpAscenseur;

    @Inject
    @RestClient
    GrpAscenseurService grpAscenseurService;

    TextIO textIO;



    @Override
    public void run() {

        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        TextIO textIO = TextIoFactory.getTextIO();


        grpAscenseur.callAscenseur(chooseGroupeAscenseur(),etage());
    }




    public String chooseGroupeAscenseur(){
        String color = textIO.newStringInputReader().read("Quel groupe d'ascenseur ? R,V,J");

        return color;
    }

    public int etage(){
        int etage = textIO.newIntInputReader().read("Quel étage ?");

        return etage;
    }

}
