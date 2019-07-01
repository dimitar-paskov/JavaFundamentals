package cresla.entities;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.modules.Modules;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements Manager {

    private int idCounter;
    private final ArrayList<Reactor> allReactors;
    private final List<Reactor> cryoReactors;
    private final List<Reactor> heatReactors;
    private final List<Identifiable> allIdentifiables;
    private int energyModules;
    private int absorbingModules;



    public ManagerImpl() {
        this.idCounter = 1;
        this.energyModules = 0;
        this.absorbingModules = 0;
        this.cryoReactors = new ArrayList<>();
        this.heatReactors = new ArrayList<>();
        this.allReactors = new ArrayList<>();
        this.allIdentifiables = new ArrayList<>();

    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String typeOfReactr = arguments.get(1);

        String result = "";
        switch (typeOfReactr){

            case "Cryo":{
                int cryoProductionIndex = Integer.parseInt(arguments.get(2));
                int moduleCapacity = Integer.parseInt(arguments.get(3));
                Reactor reactor = new CryoReactor(idCounter,cryoProductionIndex, moduleCapacity);
                this.cryoReactors.add(reactor);
                this.allReactors.add(reactor);
                this.allIdentifiables.add(reactor);
                result = String.format("Created Cryo Reactor - %d", idCounter++);
            }break;

            case "Heat":{
                int heatReductionIndex = Integer.parseInt(arguments.get(2));
                int moduleCapacity = Integer.parseInt(arguments.get(3));
                Reactor reactor = new HeatReactor(idCounter,heatReductionIndex, moduleCapacity);
                this.heatReactors.add(reactor);
                this.allReactors.add(reactor);
                this.allIdentifiables.add(reactor);
                result = String.format("Created Heat Reactor - %d", idCounter++);
            }break;
        }

        return result;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        String typeOfModule = arguments.get(2);
        int reactorId = Integer.parseInt(arguments.get(1));
        int additionalParam = Integer.parseInt(arguments.get(3));

        String result ="";
        switch (typeOfModule){
            case "CryogenRod":{
                EnergyModule module = new CryogenRod(idCounter, additionalParam);
                this.allReactors.stream().filter(r->r.getId()==reactorId).forEach(r->r.addEnergyModule(module));
                this.allIdentifiables.add(module);
                result = String.format("Added CryogenRod - %d to Reactor - %d", idCounter++, reactorId);
                this.energyModules++;
            }break;

            case "HeatProcessor":{
                AbsorbingModule module = new HeatProcessor(idCounter, additionalParam);
                this.allReactors.stream().filter(r->r.getId()==reactorId).forEach(r->r.addAbsorbingModule(module));
                this.allIdentifiables.add(module);
                result = String.format("Added HeatProcessor - %d to Reactor - %d", idCounter++, reactorId);
                this.absorbingModules++;
            }break;

            case "CooldownSystem":{
                AbsorbingModule module = new CooldownSystem(idCounter, additionalParam);
                this.allReactors.stream().filter(r->r.getId()==reactorId).forEach(r->r.addAbsorbingModule(module));
                this.allIdentifiables.add(module);
                result = String.format("Added CooldownSystem - %d to Reactor - %d", idCounter++, reactorId);
                this.absorbingModules++;
            }break;
        }


        return result;

    }

    //FIXME search is not by id, but by index in allIdentifiable
    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(1));
        final String[] result = {""};
        this.allIdentifiables.stream().filter(m->m.getId()==id).forEach(m-> result[0] =m.toString());
        return result[0];
    }

    @Override
    public String exitCommand(List<String> arguments) {

        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;

        for (Reactor reactor :
                this.allReactors) {
            long energyOutput = reactor.getTotalEnergyOutput();
            long heatAbsorbing = reactor.getTotalHeatAbsorbing();

            totalEnergyOutput += energyOutput;
            totalHeatAbsorbing += heatAbsorbing;


        }


        return String.format("Cryo Reactors: %d\n" +
                "Heat Reactors: %d\n" +
                "Energy Modules: %d\n" +
                "Absorbing Modules: %d\n" +
                "Total Energy Output: %d\n" +
                "Total Heat Absorbing: %d",
                this.cryoReactors.size(),
                this.heatReactors.size(),
                this.energyModules,
                this.absorbingModules,
                totalEnergyOutput,
                totalHeatAbsorbing);
    }
}
