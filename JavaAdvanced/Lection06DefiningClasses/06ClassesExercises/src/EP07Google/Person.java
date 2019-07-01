package EP07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    List<Pockemon> pockemonList;
    List<FamilyMeber> parents;
    List<FamilyMeber> children;
    Car car;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pockemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pockemon> getPockemonList() {
        return pockemonList;
    }

    public void setPockemonList(List<Pockemon> pockemonList) {
        this.pockemonList = pockemonList;
    }

    public List<FamilyMeber> getParents() {
        return parents;
    }

    public void setParents(List<FamilyMeber> parents) {
        this.parents = parents;
    }

    public List<FamilyMeber> getChildren() {
        return children;
    }

    public void setChildren(List<FamilyMeber> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s",
                this.name,
                this.company==null?"":this.company.toString(),
                this.car==null?"":this.car.toString(),
                this.pockemonList.isEmpty()?"":String.join("",
                        this.pockemonList.stream().map(Pockemon::toString).toArray(String[]::new)),
                this.parents.isEmpty()?"":String.join("",
                        this.parents.stream().map(FamilyMeber::toString).toArray(String[]::new)),
                this.children.isEmpty()?"":String.join("",
                        this.children.stream().map(FamilyMeber::toString).toArray(String[]::new))
                );




    }
}
