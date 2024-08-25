import java.text.SimpleDateFormat;
import java.util.Date;

public class File extends Component{
    private double size;
    public File(String name, double size, Composite parent) {
        this.setName(name);
        this.setSize(size);
        this.setParent(parent);
        this.setCreationTime(new SimpleDateFormat("dd MMMM, yyyy hh.mm aa").format(new Date()));
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "File";
    }

    @Override
    public String getDirectory() {
        return this.getParent().getDirectory() + "\\" + this.getName();
    }

    @Override
    public String toString() {
        String details = "";
        details = details.concat("Name: " + this.getName() + "\n");
        details = details.concat("Type: " + this.getType() + "\n");
        details = details.concat("Size: " + this.getSize() + " kB\n");
        details = details.concat("Directory: " + "\"" + this.getDirectory() + "\"\n");
        details = details.concat("Creation time: " + this.getCreationTime());
        return details;
    }
}
