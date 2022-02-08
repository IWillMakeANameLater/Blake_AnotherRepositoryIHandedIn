public class Moon {
    private Planet planet;
    private int orbitTime;
    private boolean atmosphere;
    private String designation;

    public Moon(Planet planet, int orbitTime, boolean atmosphere, String designation) {
        this.planet = planet;
        this.orbitTime = orbitTime;
        this.atmosphere = atmosphere;
        this.designation = designation;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public int getOrbitTime() {
        return orbitTime;
    }

    public void setOrbitTime(int orbitTime) {
        this.orbitTime = orbitTime;
    }

    public boolean isAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(boolean atmosphere) {
        this.atmosphere = atmosphere;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object obj){
        boolean isEqual = false;
        if(obj instanceof Moon){
            Moon comparedMoon = (Moon)obj;
            if(comparedMoon.getDesignation() == this.getDesignation() && comparedMoon.getOrbitTime() == this.getOrbitTime() && comparedMoon.isAtmosphere() == this.isAtmosphere() && comparedMoon.getPlanet() == this.getPlanet()){
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public String toString(){
        return "Planet: " + this.getPlanet() + ", Orbit Time: " + this.getOrbitTime() + ", Has Atmosphere: " + this.isAtmosphere() + ", Designation: " + this.getDesignation();
    }
}
