package GUI;

import java.util.ArrayList;

import Worker.Role;
import Worker.Worker;

public class LMS {
    private Worker worker;
    private ArrayList<Worker> workersList;

    public LMS() {

    }

    public static void main(String[] args) {
        LMS lms = new LMS();
        lms.SetWorkersList(lms);

        new LMSLogin(lms);
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
