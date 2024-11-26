package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("next", new ToggleStatisticCommand(new CustomBarchartLoader(), mainFrame.getBarchartDisplay()));
        mainFrame.setVisible(true);
    }
}
