package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public class CryogenRod extends BaseEnergyModule{



    public CryogenRod(int id, int energyOutput) {
        super(id,energyOutput);

    }

    @Override
    public String toString() {
        return String.format("CryogenRod Module – %d\n" +
                "Energy Output: %d",this.getId(), this.getEnergyOutput());
    }
}
