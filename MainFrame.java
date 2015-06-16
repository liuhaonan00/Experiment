import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 2269971701250845501L;

    private JPanel mainPanel = new JPanel();
    private JLabel total = new JLabel("Total:");

    private JPanel d_p1 = new JPanel(new BorderLayout());
    private JPanel f_p1 = new JPanel(new BorderLayout());
    private JPanel f_p2 = new JPanel(new BorderLayout());
    private JPanel d_p2 = new JPanel(new BorderLayout());

    private Border lineBorder = BorderFactory.createLineBorder(Color.black);
    private Font font = new Font("dialog", Font.BOLD, 18);

    private boolean isBegin = false;
    private int price1 = 0;
    private int price2 = 0;

    private int addF = 0;
    private int addD = 0;

    public MainFrame() {
        super("ice-cream shop");
        this.setBounds(300, 100, 600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(mainPanel, "Center");
        mainPanel.setLayout(new GridLayout(7, 3, 0, 0));
        mainPanel.setBackground(Color.white);

        JLabel t1 = new JLabel("ICE-CREAM Flavor");
        t1.setBorder(lineBorder);
        t1.setFont(font);
        mainPanel.add(t1);
        JLabel t2 = new JLabel("Decorator");
        t2.setBorder(lineBorder);
        t2.setFont(font);
        mainPanel.add(t2);
        JButton b1 = new JButton("[New IceCream]");
        b1.setBorder(lineBorder);
        b1.setFont(font);
        b1.setBackground(Color.blue);
        mainPanel.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isBegin = true;
                price1 = 0;
                price2 = 0;
            }
        });

        JButton b2 = new JButton("[Chocolate,$20]");
        b2.setBorder(lineBorder);
        b2.setFont(font);
        b2.setBackground(Color.blue);
        mainPanel.add(b2);
        JButton b3 = new JButton("[M&M,$5]");
        b3.setBorder(lineBorder);
        b3.setFont(font);
        b3.setBackground(Color.blue);
        mainPanel.add(b3);
        JLabel l1 = new JLabel();
        l1.setBorder(lineBorder);
        mainPanel.add(l1);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                price1 = 20;
                setTotle();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                price2 = 5;
                setTotle();
            }
        });

        JButton b4 = new JButton("[Vanilla,$20]");
        b4.setBorder(lineBorder);
        b4.setFont(font);
        b4.setBackground(Color.blue);
        mainPanel.add(b4);
        JButton b5 = new JButton("[Strawberry,$4]");
        b5.setBorder(lineBorder);
        b5.setFont(font);
        b5.setBackground(Color.blue);
        mainPanel.add(b5);
        JLabel l2 = new JLabel();
        l2.setBorder(lineBorder);
        mainPanel.add(l2);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                price1 = 20;
                setTotle();
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                price2 = 4;
                setTotle();
            }
        });

        f_p1.setBorder(lineBorder);
        mainPanel.add(f_p1);
        d_p1.setBorder(lineBorder);
        mainPanel.add(d_p1);
        JLabel ll1 = new JLabel();
        ll1.setBorder(lineBorder);
        mainPanel.add(ll1);

        f_p2.setBorder(lineBorder);
        mainPanel.add(f_p2);
        d_p2.setBorder(lineBorder);
        mainPanel.add(d_p2);
        JLabel ll2 = new JLabel();
        ll2.setBorder(lineBorder);
        mainPanel.add(ll2);

        JLabel l3 = new JLabel();
        l3.setBorder(lineBorder);
        mainPanel.add(l3);
        JLabel l4 = new JLabel();
        l4.setBorder(lineBorder);
        mainPanel.add(l4);
        total.setFont(font);
        total.setBorder(lineBorder);
        mainPanel.add(total);

        JButton b6 = new JButton("[System Administartor]");
        b6.setBorder(lineBorder);
        b6.setFont(font);
        b6.setBackground(Color.blue);
        mainPanel.add(b6);
        JLabel l5 = new JLabel();
        l5.setBorder(lineBorder);
        mainPanel.add(l5);
        JLabel l6 = new JLabel();
        l6.setBorder(lineBorder);
        mainPanel.add(l6);

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddDialog dia = new AddDialog();
                dia.setVisible(true);
            }
        });

    }

    private void setTotle() {
        if (isBegin) {
            total.setText("Total:" + (price1 + price2));
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    private class AddDialog extends JDialog implements ActionListener {
        private static final long serialVersionUID = 1L;

        private JRadioButton bf = new JRadioButton("ICE-CREAM Flavor");
        private JRadioButton bd = new JRadioButton("Decorator");
        private JTextField t_name = new JTextField(20);
        private JTextField t_price = new JTextField(20);

        private JButton btn = new JButton("confirm");

        public AddDialog() {
            super(MainFrame.this);
            setTitle("add menu");
            this.setModal(true);
            int x = MainFrame.this.getX();
            int y = MainFrame.this.getY();
            this.setSize(300, 200);
            this.setLocation(x, y);

            Container c = this.getContentPane();
            c.setLayout(new GridLayout(2, 1, 0, 0));
            JPanel p1 = new JPanel(new FlowLayout());
            c.add(p1);
            JPanel p2 = new JPanel(new FlowLayout());
            c.add(p2);
            p1.add(new JLabel("menu types:"));
            ButtonGroup bg = new ButtonGroup();
            bg.add(bd);
            bg.add(bf);
            p1.add(bf);
            p1.add(bd);
            bf.setSelected(true);

            p2.add(new JLabel("name:"));
            p2.add(t_name);
            p2.add(new JLabel("price:"));
            p2.add(t_price);
            p2.add(btn);
            btn.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = t_name.getText();
            final String price = t_price.getText();
            JButton button = new JButton("[" + name + ",$" + price + "]");
            button.setFont(font);
            button.setBackground(Color.blue);
            if (bf.isSelected()) {
                if (addF == 0) {
                    f_p1.add(button, "Center");
                    f_p1.updateUI();
                    addF++;
                } else if (addF == 1) {
                    f_p2.add(button, "Center");
                    f_p2.updateUI();
                }
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        price1 = Integer.parseInt(price);
                        setTotle();
                    }
                });
            } else {
                if (addD == 0) {
                    d_p1.add(button, "Center");
                    d_p1.updateUI();
                    addD++;
                } else if (addD == 1) {
                    d_p2.add(button, "Center");
                    d_p2.updateUI();
                }
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        price2 = Integer.parseInt(price);
                        setTotle();
                    }
                });
            }
            this.setVisible(false);
            this.dispose();
        }
    }
}
