package fr.pantheonsorbonne.ufr27.miage.cli;

import fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.dto.GrpAscenseur;
import fr.pantheonsorbonne.ufr27.miage.resource.AscenseurService;
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
    AscenseurService ascenseurService;

    TextIO textIO;

    @Override
    public void run() {

        TextIO textIO = TextIoFactory.getTextIO();
        displayAscenseur();
        grpAscenseur.callAscenseur(chooseGroupeAscenseur(),etage());
    }

    public void displayAscenseurByColor(String color){
        terminal.println("Tout les ascenseur " + color);
        for (Ascenseur ascenseur : ascenseurService.getAscenseurByColor(color)) {
            terminal.println("[" + ascenseur.getId() + "] " + ascenseur.getEtage() + ascenseur.isInError());
        }
    }
    public void displayAscenseur(){
        terminal.println("Tout les ascenseurs");
        for (Ascenseur ascenseur : ascenseurService.getAscenseur()) {
            terminal.println("[" + ascenseur.getId() + "] " + ascenseur.getEtage() + ascenseur.isInError());
        }
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
