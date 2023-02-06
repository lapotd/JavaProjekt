package Menus;

public interface IMenu {
    String ShowMenu();
    IMenu HandleDecision(String decision);
}
