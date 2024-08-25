import java.text.SimpleDateFormat;
import java.util.Date;

public class Drive extends Composite{
    public Drive(String name, final Composite parent){
        this.setName(name);
        this.setParent(parent);
        this.setCreationTime(new SimpleDateFormat("dd MMMM, yyyy hh.mm aa").format(new Date()));
    }

    @Override
    String getType() {
        return "Drive";
    }

    @Override
    String getDirectory() {
        return this.getName() + ":";
    }

    @Override
    void makeDrive(String name) {
        System.out.println("The operation is not permitted here.");
    }

    @Override
    void makeDirectory(String name){
        this.getComponents().put(name, new Folder(name, this));
    }

    @Override
    void createFile(String name, double size) {
        this.getComponents().put(name, new File(name, size, this));
    }
}
