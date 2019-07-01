package cresla.entities.reactors;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

public class CryoReactor extends Reactors {
    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {

        long Energy = super.getTotalEnergyOutput()*this.cryoProductionIndex;
        long heatAbsortion = this.getTotalHeatAbsorbing();

        if (Energy > heatAbsortion){
            Energy = 0;
        }


        return Energy;
    }



    @Override
    public String toString() {

        return String.format("CryoReactor - %d\n" +
                "Energy Output: %d\n" +
                "Heat Absorbing: %d\n" +
                "Modules: %d",this.getId(), this.getTotalEnergyOutput(), this.getTotalHeatAbsorbing(), this.getModuleCount() );
    }
}
