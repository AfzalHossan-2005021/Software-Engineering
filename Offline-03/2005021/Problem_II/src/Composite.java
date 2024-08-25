import java.util.HashMap;

public abstract class Composite extends Component {

    private final HashMap<String, Component> components = new HashMap<>();

    abstract void makeDrive(String name);

    abstract void makeDirectory(String name);

    abstract void createFile(String name, double size);

    boolean isEmpty() {
        return this.getComponents().isEmpty();
    }

    public HashMap<String, Component> getComponents() {
        return components;
    }

    public void showDetails(String name) {
        System.out.println(this.getComponents().get(name));
    }

    public void Delete(String name) {
        if(this.getComponents().containsKey(name)){
            Component component = this.components.get(name);
            if(component instanceof File){
                this.components.remove(name);
            } else if(component instanceof Composite) {
                if(((Composite)this.components.get(name)).isEmpty()) {
                    this.components.remove(name);
                } else {
                    System.out.println("Error: The Drive/Folder is not empty.");
                }
            }
        } else {
            System.out.println("Error: There is no File/Folder with this name.");
        }
    }

    public void recursiveDelete(String name) {
        if(this.getComponents().containsKey(name)){
            Component component = this.components.get(name);
            if(component instanceof File){
                System.out.println("Warning: Target component is an instance of file.");
            } else if(component instanceof Composite) {
                ((Composite) component).deleteAllContents();
            }
            this.components.remove(name);
        } else {
            System.out.println("Error: There is no File/Folder with this name.");
        }
    }

    private void deleteAllContents() {
        for (Component component : this.components.values()){
            if(component instanceof Composite){
                ((Composite) component).deleteAllContents();
            }
        }
        this.components.clear();
    }

    public void showComponentList(){
        for (Component component : this.components.values()){
            System.out.println(component.getName() + "\t\t\t" + component.getSize() + " kB\t\t\t" + component.getCreationTime());
        }
    }

    @Override
    public double getSize(){
        double size = 0;
        for (Component component : components.values()){
            size += component.getSize();
        }
        return size;
    }

    @Override
    public String toString() {
        String details = "";
        details = details.concat("Name: " + this.getName() + "\n");
        details = details.concat("Type: " + this.getType() + "\n");
        details = details.concat("Size: " + this.getSize() + " kB\n");
        details = details.concat("Directory: " + "\"" + this.getDirectory() + "\"\n");
        details = details.concat("Component Count: " + this.components.size() + "\n");
        details = details.concat("Creation time: " + this.getCreationTime());
        return details;
    }
}
