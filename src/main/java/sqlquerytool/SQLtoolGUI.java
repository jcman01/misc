package sqlquerytool;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.text.*;

public class SQLtoolGUI extends JPanel implements ActionListener {
    private JTable table;
    private JSplitPane splitPane;
    private JTextArea textArea;
    private JMenuBar menubar;
    private JMenu menuFile;
    private JMenu menuRun;
    private JMenuItem menuItemRunSQL;
    private JMenuItem menuItemDBCon;
    private JMenuItem menuItemExit;
    private JLabel labelStatus;
    private JPanel panelStatus;
    private String connectString;
    private Connection conn;
    private static final long serialVersionUID = 1L;
    private static Pattern regex = Pattern.compile("\\S+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

    public SQLtoolGUI(String db) {
        createTextArea();
        createJTable();
        createSplitPanes();
        createMenus();
        createStatusBar();
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setColumns(80);
        textArea.setRows(25);
        textArea.setFont(new Font("DialogInput", Font.PLAIN, 12));
        registerListeners(textArea);
    }

    private void createJTable() {
        table = new JTable(new DefaultTableModel(new String[0], 0));
        table.setPreferredScrollableViewportSize(new Dimension(5, 120));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    private void createSplitPanes() {
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
                new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        splitPane.setDividerLocation(0.5);
        splitPane.setSize(new Dimension(500, 500));
        splitPane.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
    }

    private void createMenus() {
        menubar = new JMenuBar();
        menuFile = new JMenu("File");
        menuRun = new JMenu("Run");
        menuItemRunSQL = new JMenuItem("Run SQL");
        menuItemRunSQL.setEnabled(false);
        menuItemDBCon = new JMenuItem("Connection");
        menuItemExit = new JMenuItem("Exit");
        menuRun.add(menuItemRunSQL);
        menuFile.add(menuItemExit);
        menuFile.add(menuItemDBCon);
        menubar.add(menuFile);
        menubar.add(menuRun);
        menuItemRunSQL.addActionListener(this);
        menuItemDBCon.addActionListener(this);
        menuItemExit.addActionListener(this);
    }

    private void createStatusBar() {
        panelStatus = new JPanel();
        panelStatus.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panelStatus.setLayout(new BoxLayout(panelStatus, BoxLayout.X_AXIS));
        labelStatus = new JLabel(" ");
        labelStatus.setHorizontalAlignment(SwingConstants.LEFT);
        panelStatus.add(labelStatus);
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public JMenuBar getJMenuBar() {
        return menubar;
    }

    public JPanel getStatusPanel() {
        return panelStatus;
    }

    private void registerListeners(JTextArea textArea) {
        textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                int modifiers = e.getModifiers();

                if (conn != null) {
                    if (code == KeyEvent.VK_ENTER && modifiers == KeyEvent.CTRL_MASK) {
                        try {
                            int rows = runSQL();
                            setStatusLabel(rows);
                        } catch (SQLException s) {
                            setStatusLabel(connectString, s.getMessage());
                            table.setModel(new DefaultTableModel(new String[1], 0));
                        }
                    }
                }
            }
        });
    }

    public String getSQLText() {
        String[] allTextBlock = textArea.getText().split("\\n", -1);
        String relevantTextBlock = null;
        int currentLine = 0;
        int blockBegin = 0;
        int blockEnd = 0;

        // compute the current line number
        try {
            currentLine = textArea.getLineOfOffset(textArea.getCaretPosition());
        } catch (BadLocationException blx) {
            return null;
        }

        // find where the current relevant block of SQL text begins
        if (regex.matcher(allTextBlock[currentLine]).find()) {
            blockBegin = currentLine;
            while (blockBegin > 0) {
                if (regex.matcher(allTextBlock[blockBegin]).find()) {
                    --blockBegin;
                } else {
                    break;
                }
            }

            // find where the current relevant block of SQL text ends
            blockEnd = currentLine;
            while (blockEnd < allTextBlock.length) {
                if (regex.matcher(allTextBlock[blockEnd]).find()) {
                    blockEnd++;
                } else {
                    break;
                }
            }

            // return the selected block
            relevantTextBlock = new String();
            for (int i = blockBegin; i < blockEnd; i++) {
                relevantTextBlock += allTextBlock[i] + " ";
            }
        }
        return relevantTextBlock;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Run SQL")) {
            try {
                int rows = this.runSQL();
                setStatusLabel(rows);
            } catch (SQLException s) {
                setStatusLabel(connectString, s.getMessage());
                table.setModel(new DefaultTableModel(new String[1], 0));
            }
        } else {
            if (ae.getActionCommand().equals("Exit")) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                } finally {
                    System.exit(0);
                }
            } else {
                if (ae.getActionCommand().equals("Connection")) {
                    try {
                        getConnection();
                        setStatusLabel(connectString);
                        menuItemRunSQL.setEnabled(true);
                    } catch (SQLException s) {
                        table.setModel(new DefaultTableModel());
                        setStatusLabel(s.getMessage());
                    }
                }
            }
        }
    }

    private void setStatusLabel(String status) {
        labelStatus.setText(status);
    }

    private void setStatusLabel(int rows) {
        String spaces = "            ";
        labelStatus.setText(connectString + spaces + "Rows: " + new Integer(rows).toString());
    }

    private void setStatusLabel(String status1, String status2) {
        String spaces = "            ";
        labelStatus.setText(connectString + spaces + status2);
    }

    final private int runSQL() throws SQLException {
        String[] columnNames;
        Object[] data;
        DefaultTableModel model;
        int rows = 0;

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getSQLText());
        columnNames = new String[rs.getMetaData().getColumnCount()];

        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            columnNames[i - 1] = rs.getMetaData().getColumnLabel(i);
        }

        model = new DefaultTableModel(columnNames, 0);
        data = new Object[rs.getMetaData().getColumnCount()];

        while (rs.next()) {
            rows++;
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                data[i] = rs.getString(i + 1);
            }
            model.addRow(data);
        }
        table.setModel(model);
        stmt.close();
        rs.close();
        return rows;
    }

    private String getConnection() throws SQLException {
        UsernamePasswordDialog userPassDiag = new UsernamePasswordDialog(null);
        userPassDiag.setVisible(true);

        connectString = "jdbc:oracle:thin:@//"
                //                connectString = "jdbc:mysql://"
                + userPassDiag.gettextFieldHost() + ":"
                + userPassDiag.gettextFieldPort() + "/"
                + userPassDiag.gettextFieldDb();

        try {
            Class.forName("oracle.jdbc.OracleDriver");
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectString, userPassDiag.gettextFieldUID(), userPassDiag.getjPasswordField());
        } catch (ClassNotFoundException c) {
            setStatusLabel(c.getMessage());
        }
        return connectString;
    }

    private static void createAndShowGUI() throws Exception {
        JFrame frame = new JFrame("FreeSQL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SQLtoolGUI nf = new SQLtoolGUI("SQLtoolGUI");
        frame.getContentPane().add(nf.getSplitPane());
        frame.setJMenuBar(nf.getJMenuBar());
        frame.add(nf.getStatusPanel(), BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
