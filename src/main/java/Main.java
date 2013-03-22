import org.rich.BootstrapRich;

public final class Main {
    private Main(){}

    public static void main(String[] args) {
        BootstrapRich bootstrapRich = new BootstrapRich();
        bootstrapRich.init();
        bootstrapRich.start();
        bootstrapRich.close();
    }
}
