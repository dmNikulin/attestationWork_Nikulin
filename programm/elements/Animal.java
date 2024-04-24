package programm.elements;

public class Animal {
    public String name;
    public String birtday;
    public String command;
    
    public Animal(String name, String birtday, String command) {
        this.name = name;
        this.birtday = birtday;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "Кличка: " + name + " \nДата рождения: " + birtday + "\nКоманды: " + command + "\n";
    }
    
}
