public abstract class Component {
    private String name;
    private String creationTime;
    private Composite parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Composite getParent() {
        return parent;
    }

    public void setParent(Composite parent) {
        this.parent = parent;
    }

    abstract double getSize();

    abstract String getType();

    abstract String getDirectory();

}
