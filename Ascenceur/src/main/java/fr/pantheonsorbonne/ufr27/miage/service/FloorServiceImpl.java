package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.TechGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.AscenseurDAO;
import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.AscenseurHSException;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;
import fr.pantheonsorbonne.ufr27.miage.exception.NotServedFloorException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class FloorServiceImpl implements FloorService{

    @Inject
    AscenseurDAO ascDAO;

    @Inject
    TechGateway techGateway;

    @Override
    public void goToFloor(String floor,String group, int idAsc) throws AscenseurHSException, NotServedFloorException {
        try {
            List<String> lineFloor = Arrays.asList(ascDAO.getSelectedFloors(idAsc).split(";"));
            List<String> servedFloor = Arrays.asList(ascDAO.getServedFloors(group, idAsc).split(";"));

            if (!servedFloor.contains(floor)) {
                throw new NotServedFloorException();
            }

            if (!lineFloor.contains(floor)) {
                ascDAO.addFloor(floor, idAsc);
            }

        } catch (NoResultException e){
            techGateway.sendHsAlert(ascDAO.getHSAsc(idAsc));
            throw new AscenseurHSException();
        }
    }

    @Override
    public List<Integer> getServedFloors(String group, int idAsc) throws NoAscenseurAvailableException {

        List<String> lineeFloor = Arrays.asList(ascDAO.getServedFloors(group, idAsc).split(";"));

        if(lineeFloor.isEmpty()){
            throw new NoAscenseurAvailableException();
        }
        List<Integer> listFloor = new ArrayList<>();
        for (String s : lineeFloor){
            listFloor.add(Integer.parseInt(s));
        }

        return listFloor;

    }

    @Override
    public boolean verifyAvailabilityGroup(String group, String sens) throws NoAscenseurAvailableException {

        boolean sensAsc = false;
        if(sens.equals("up")){
            sensAsc = true;
        }
        if(sens.equals("down")){
            sensAsc = false;
        }

        Collection<Ascenseur> ascenseurs = ascDAO.verifAvailabilityGroup(group,sensAsc);


        if (ascenseurs.isEmpty()){
            throw new NoAscenseurAvailableException();
        }
        return true;
    }

    @Override
    public Collection<Ascenseur> getAvailableAtFloor(String group, String sens, int floor) throws NoAscenseurAvailableException {
        boolean sensAsc = false;

        if(sens.equals("up")){
            sensAsc = true;
        }
        if(sens.equals("down")){
            sensAsc = false;
        }
        Collection<Ascenseur> ascenseurs = ascDAO.verifAvailabilityAtFloor(group,sensAsc, floor);
        if(ascenseurs.isEmpty()){
            throw new NoAscenseurAvailableException();
        }

        return ascenseurs;

    }

    public void deleteFloor(String floor, int idAsc) throws NotServedFloorException {
        List<String> selectedFloor = new ArrayList<String>();
        selectedFloor.addAll(Arrays.asList(ascDAO.getSelectedFloors(idAsc).split(";")));

        StringBuilder updatedSelectFloors = new StringBuilder("");
        if (!selectedFloor.contains(floor)) {
            throw new NotServedFloorException();
        } else {
            selectedFloor.remove(floor);
            for (String afloor : selectedFloor) {
                updatedSelectFloors.append(afloor + ";");
            }
        }
        ascDAO.deleteFloor(updatedSelectFloors.toString(), idAsc);
    }


}
