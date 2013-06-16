package sqlquerytool;

import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;

public class UsernamePasswordDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    boolean frameSizeAdjusted = false;
    private JLabel jLabelHost = new JLabel("Host:");
    private JLabel jLabelPort = new JLabel("Port");
    private JLabel jLabelDb = new JLabel("DB:");
    private JLabel jLabelUID = new JLabel("User ID:");
    private JLabel jLabelPwd = new JLabel("Password:");
    private JTextField textFieldHost = new JTextField();
    private JTextField textFieldPort = new JTextField();
    private JTextField textFieldDb = new JTextField();
    private JTextField textFieldUID = new JTextField();
    private JPasswordField jPasswordField = new JPasswordField();
    private JButton jButtonOK = new JButton("OK");
    private JButton jButtonCancel = new JButton("Cancel");

    public UsernamePasswordDialog(Frame frame) {
        super(frame, true);
        setTitle("Database Connection");
        getContentPane().setLayout(null);
        setSize(403, 280);
        setVisible(false);

        getContentPane().add(jLabelHost);
        jLabelHost.setBounds(12, 12, 48, 24);
        getContentPane().add(textFieldHost);
        textFieldHost.setBounds(72, 12, 324, 24);

        getContentPane().add(jLabelPort);
        jLabelPort.setBounds(12, 52, 48, 24);
        getContentPane().add(textFieldPort);
        textFieldPort.setBounds(72, 52, 324, 24);

        getContentPane().add(jLabelDb);
        jLabelDb.setBounds(12, 92, 48, 24);
        getContentPane().add(textFieldDb);
        textFieldDb.setBounds(72, 92, 324, 24);

        getContentPane().add(jLabelUID);
        jLabelUID.setBounds(12, 132, 48, 24);
        getContentPane().add(textFieldUID);
        textFieldUID.setBounds(72, 132, 324, 24);

        getContentPane().add(jLabelPwd);
        jLabelPwd.setBounds(12, 172, 72, 24);
        getContentPane().add(jPasswordField);
        jPasswordField.setBounds(72, 172, 324, 24);

        getContentPane().add(jButtonOK);
        jButtonOK.setBounds(60, 212, 84, 24);

        getContentPane().add(jButtonCancel);
        jButtonCancel.setBounds(264, 212, 84, 24);

        SymAction lSymAction = new SymAction();
        jButtonOK.addActionListener(lSymAction);
        jButtonCancel.addActionListener(lSymAction);

//        textFieldHost.setText("drupaldev2.wpprivate.com");
//        textFieldPort.setText("3306");
//        textFieldDb.setText("drupal");
//        textFieldUID.setText("drupal");
//        jPasswordField.setText("4drupal");

        textFieldHost.setText("9idbtest");
        textFieldPort.setText("10401");
        textFieldDb.setText("t1wli");
        textFieldUID.setText("portaldev");
        jPasswordField.setText("wlp0rtal920");

    }

    public String gettextFieldHost() {
        return textFieldHost.getText();
    }

    public String gettextFieldPort() {
        return textFieldPort.getText();
    }

    public String gettextFieldDb() {
        return textFieldDb.getText();
    }

    public String gettextFieldUID() {
        return textFieldUID.getText();
    }

    public String getjPasswordField() {
        return new String(jPasswordField.getPassword());
    }

    public void setVisible(boolean b) {
        if (b) {
            setLocation(50, 50);
        }
        super.setVisible(b);
    }

    public void addNotify() {
        super.addNotify();
        setSize(getInsets().left + getInsets().right + getSize().width, getInsets().top + getInsets().bottom + getSize().height);
    }
    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == jButtonOK) {
                Ok_actionPerformed(event);
            } else if (object == jButtonCancel) {
                Cancel_actionPerformed(event);
            }
        }
    }

    void Ok_actionPerformed(java.awt.event.ActionEvent event) {
        setVisible(false);
    }

    void Cancel_actionPerformed(java.awt.event.ActionEvent event) {
        textFieldDb.setText("");
        jPasswordField.setText("");
        setVisible(false);
    }
}
