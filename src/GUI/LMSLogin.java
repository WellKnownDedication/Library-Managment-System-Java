package GUI;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Worker.Worker;

public class LMSLogin {
    private LMS lms;

    private JFrame frame;
    private JPanel panel;

    private JTextField UserField;
    private JPasswordField PasswordField;

    private JLabel StatusLabel;

    public LMSLogin(LMS lms) {
        this.lms = lms;
        frame = new JFrame();

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
        this.InitFields();

        frame.setVisible(true);
    }

    private void InitFields() {
        final int LABEL_WIDTH = 100;
        final int LABEL_HEIGHT = 20;

        StatusLabel = new JLabel("");
        StatusLabel.setBounds(30, 25, LABEL_WIDTH * 3, LABEL_HEIGHT);
        panel.add(StatusLabel);

        JLabel UserLabel = new JLabel("User");
        UserLabel.setBounds(50, 50, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(UserLabel);

        UserField = new JTextField();
        UserField.setBounds(120, 50, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(UserField);

        JLabel PasswordLabel = new JLabel("Password");
        PasswordLabel.setBounds(50, 75, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(PasswordLabel);

        PasswordField = new JPasswordField();
        PasswordField.setBounds(120, 75, LABEL_WIDTH, LABEL_HEIGHT);
        panel.add(PasswordField);

        JButton button = new JButton();
        button.setText("Confirm");
        button.setBounds(75, 120, LABEL_WIDTH, LABEL_HEIGHT);
        button.addActionListener(e -> this.CheckLogIn(this.lms));
        panel.add(button);
    }

    private void CheckLogIn(LMS lms) {
        // TODO: possible redo with db integration
        ArrayList<Worker> workersList = lms.GetWorkersLsit();

        for (int i = 0; i < workersList.size(); i++) {
            Worker worker = workersList.get(i);

            if (UserField.getText() == worker.GetUserName()) {
                boolean fComp = Arrays.equals(PasswordField.getPassword(), worker.GetPassword());
                boolean sComp = Arrays.equals(worker.GetPassword(), PasswordField.getPassword());

                if (fComp && sComp) {
                    lms.SetWorker(worker);
                    return;
                }
            }
        }

        StatusLabel.setText("Username or password is incorrect.");
    }

}
