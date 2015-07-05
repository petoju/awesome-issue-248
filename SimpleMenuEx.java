import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleMenuEx extends JFrame {

    public SimpleMenuEx() {

        initUI();
    }

    private void initUI() {
        
        createMenuBar();

        setTitle("Simple menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("FileA");
		file.setMnemonic(KeyEvent.VK_A);

        file.add(getMenuItem("FileA1"));
        file.add(getMenuItem("FileA2"));
        file.add(getMenuItem("FileA3"));
        file.add(getMenuItem("FileA4"));
        file.add(getMenuItem("FileA5"));
        menubar.add(file);

		file = new JMenu("FileB");
		file.setMnemonic(KeyEvent.VK_B);

        file.add(getMenuItem("FileB1"));
        file.add(getMenuItem("FileB2"));
        file.add(getMenuItem("FileB3"));
        file.add(getMenuItem("FileB4"));
        file.add(getMenuItem("FileB5"));
        menubar.add(file);


        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SimpleMenuEx ex = new SimpleMenuEx();
                ex.setVisible(true);
            }
        });
    }

	private JMenuItem getMenuItem(String text) {
        JMenuItem eMenuItem = new JMenuItem(text);
        eMenuItem.addActionListener(new PrintAction(text));
		return eMenuItem;
	}


	private static class PrintAction implements ActionListener {
		private final String what;

		PrintAction(String what) {
			this.what = what;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println(what);
		}
	}
}

