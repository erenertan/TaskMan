package forms;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Project: TaskMan
 * <p>
 * Date: 26 Tem 2016
 * Author: Tarık İNCE <incetarik@hotmail.com>
 */
public class MainForm extends JFrame {
    private JTextField tfWatch;

    public MainForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        /* Steps to initialize components:
         * 1) Initialize layout to add components
         * 2) Initialize the components
         * 3) add() the components to this form (layout we set in first step)
         * 4) Invoke/call any other methods if needed
         * 5) pack() */

        setLayout(new MigLayout());
        initMenu();

        // Component initializations
        tfWatch = new JTextField();

        // pack methods calculates the minimum space required for this window
        // and resizes it.
        pack();
    }

    /**
     * Initializes the application menu
     */
    private void initMenu() {
        JMenuBar bar = new JMenuBar();

        /* All of actions are set as lambda to get rid of redundant space
         * and to prevent the code from being too verbose */

        // File Menu
        JMenu menuFile = new JMenu("Dosya");
        JMenuItem miOpen = new JMenuItem("Aç...");
        JMenuItem miSave = new JMenuItem("Kaydet");
        JMenuItem miExport = new JMenuItem("Dışa ver...");
        JMenuItem miExit = new JMenuItem("Çıkış");

        miOpen.addActionListener(e -> {

        });

        miSave.addActionListener(e -> {

        });

        miExport.addActionListener(e -> {

        });

        miExit.addActionListener(e -> {

        });

        menuFile.add(miOpen);
        menuFile.add(miSave);
        menuFile.add(miExport);
        menuFile.add(new JSeparator());
        menuFile.add(miExit);
        bar.add(menuFile); // End of File menu

        // Management Menu
        JMenu menuMan = new JMenu("Yönetim");
        JMenuItem miAddStu = new JMenuItem("Öğrenci Ekle");
        JMenuItem miFilterStu = new JMenuItem("Öğrencileri Filtrele");
        JMenuItem miAssignStu = new JMenuItem("Öğrenciyi Ata...");
        JMenuItem miScheduler = new JMenuItem("Görev Zamanlayıcısı");

        miAddStu.addActionListener(e -> {

        });

        miFilterStu.addActionListener(e -> {

        });

        miAssignStu.addActionListener(e -> {

        });

        miScheduler.addActionListener(e -> {

        });

        menuMan.add(miAddStu);
        menuMan.add(miFilterStu);
        menuMan.add(miAssignStu);
        menuMan.add(new JSeparator());
        menuMan.add(miScheduler);
        bar.add(menuMan); // End of Management menu

        setJMenuBar(bar);
    }

    /**
     * Initializes a watch which is the same with system time.
     *
     * @param field JTextField to set time.
     */
    private void initWatch(JTextField field) {
        if (field == null) return;
        // We create SimpleDateFormat to format a date as Hour:Minute:Second
        // we have written twice to format with leading zeros.
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        // java.util.Calendar class helps us to get current date,
        // editing it easily as adding specific amount to specific field.
        Calendar calendar = Calendar.getInstance();

        // Application.timer is a timer class that runs on background so
        // does not block application. We call this function at fixed rate,
        // namely in every [second, minute, hour, etc... in milliseconds]
        // by starting this timer after a specific milliseconds (delay) which is 0.
        Application.timer.addRepeating(1000, () -> {
            // Set current time after formatting it to tfWatch
            field.setText(format.format(calendar.getTime()));

            // Now add one second to calendar.
            calendar.add(Calendar.SECOND, 1);
        });
    }
}
