package Game.GameData.Enums;

public enum PathwayType {
    OPEN("the path is open.", true),
    NONE("there is no path at all.", false);

    private String pathwayDesc;
    private boolean pathwayState;

    PathwayType(String pathwayDesc, boolean pathwayState){
        this.pathwayDesc = pathwayDesc;
        this.pathwayState = pathwayState;
    }

    public boolean isPathwayState() {
        return pathwayState;
    }

    public void setPathwayState(boolean pathwayState) {
        this.pathwayState = pathwayState;
    }

    public String getPathwayDesc() {
        return pathwayDesc;
    }
}
