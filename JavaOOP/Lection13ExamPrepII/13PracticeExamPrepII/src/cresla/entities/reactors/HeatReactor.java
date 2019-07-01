package cresla.entities.reactors;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

public class HeatReactor extends Reactors {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing()+ this.heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {

        long Energy = super.getTotalEnergyOutput();
        long heatAbsortion = this.getTotalHeatAbsorbing();

        if (Energy > heatAbsortion){
            Energy = 0;
        }


        return Energy;
    }

    @Override
    public String toString() {

        return String.format("HeatReactor - %d\n" +
                "Energy Output: %d\n" +
                "Heat Absorbing: %d\n" +
                "Modules: %d",this.getId(), this.getTotalEnergyOutput(), this.getTotalHeatAbsorbing(), this.getModuleCount() );
    }
}
