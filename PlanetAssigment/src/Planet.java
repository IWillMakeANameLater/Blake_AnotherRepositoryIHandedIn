import java.util.ArrayList;

public class Planet {
    private int orbitTime;
    private ArrayList<Moon> moons;
    private String designation;

    public Planet(){
        orbitTime = 0;
        moons = new ArrayList<>();
        designation = "";
    }

    public Planet(int orbitTime, String designation){
        this.designation = designation;
        this.orbitTime = orbitTime;
        moons = new ArrayList<>();
    }

    public int getOrbitTime() {
        return orbitTime;
    }

    public void setOrbitTime(int orbitTime) {
        this.orbitTime = orbitTime;
    }

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public void addMoon(Moon moon) {
        this.moons.add(moon);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object obj){
        boolean isEquals = false;
        if(obj instanceof Planet){
            Planet planet = (Planet) obj;
            if(planet.getOrbitTime() == this.orbitTime && planet.designation == this.designation && planet.moons == this.moons){
                isEquals = true;
            }
        }
        return isEquals;
    }

    @Override
    public String toString(){
        return "Designation: " + this.designation + ", Orbit Time: " + this.orbitTime + ", Moons: " + this.moons;
    }
}
