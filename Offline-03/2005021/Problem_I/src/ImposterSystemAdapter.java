public class ImposterSystemAdapter implements ImposterSystemInterface {
    private final CrewmateSystemInterface adaptee;

    public ImposterSystemAdapter(CrewmateSystemInterface adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void login() {
        adaptee.login();
        System.out.println("We won’t tell anyone; you are an imposter.");
    }

    @Override
    public void repair() {
        adaptee.repair();
        System.out.println("Damaging the spaceship.");
    }

    @Override
    public void work() {
        adaptee.work();
        System.out.println("Trying to kill a crewmate.\nSuccessfully killed a crewmate.");
    }

    @Override
    public void logout() {
        adaptee.logout();
        System.out.println("See you again Comrade Imposter.");
    }
}
