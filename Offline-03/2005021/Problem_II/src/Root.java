public class Root extends Composite {
    private static Root root = null;
    private Root(){
        this.setParent(this);
    }

    public static Root getRoot(){
        if(root == null){
            root = new Root();
        }
        return root;
    }

    @Override
    String getType() {
        return "Root";
    }

    @Override
    String getDirectory() {
        return "";
    }

    @Override
    void makeDrive(String name) {
        this.getComponents().put(name, new Drive(name, this));
    }

    @Override
    void makeDirectory(String name){
        System.out.println("The operation is not permitted here.");
    }

    @Override
    void createFile(String name, double size) {
        System.out.println("The operation is not permitted here.");
    }
}
