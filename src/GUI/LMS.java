package GUI;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Worker.Role;
import Worker.Worker;

public class LMS {
    private Worker worker;
    private ArrayList<Worker> workersList;

    JFrame frame;
    JPanel panel;

    public static void main(String[] args) {
        LMS lms = new LMS();
        lms.SetWorkersList(lms);

        new LMSLogin(lms);
    }

    public void ShowFrame() {
        this.frame = new JFrame();

        this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Library Managment System");

        this.panel = new JPanel();
        this.frame.add(panel);

        this.panel.setLayout(null);

        this.frame.setVisible(true);
    }

    private void SetWorkersList(LMS lms) {
        // TODO: implement this with db
        lms.workersList = new ArrayList<Worker>();
        lms.workersList.add(new Worker("Admin", "conInfo", "admin".toCharArray(), Role.ADMIN));
    }

    public void SetWorker(Worker worker) {
        this.worker = worker;
    }

    public ArrayList<Worker> GetWorkersLsit() {
        return this.workersList;
    }

}
