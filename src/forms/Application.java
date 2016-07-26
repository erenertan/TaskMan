package forms;

import helpers.Timer;
import stuman.StudentManager;

public class Application {
    static Timer timer;

    /**
     * This should be called in main only, so it is private.
     */
    private static void initialize() {
        timer = new Timer();
        StudentManager.initialize();
    }

    public static void main(String[] args) {
        initialize();
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }
}
