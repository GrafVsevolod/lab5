package commands;

public interface Command {
    public void execute(String[] args) throws Exception;

    public String getName();

    public String getDescription();
}
