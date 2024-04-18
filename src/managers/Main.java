package managers;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        System.out.println("Введите команду 'help', чтобы увидеть все доступные команды");
        String filename = args[0];
        console.setFileName(filename);
        console.start(System.in);
    }
}
