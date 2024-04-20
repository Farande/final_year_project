package ProjectInterface;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

public class visualisation1 extends JFrame implements ActionListener {
    JButton quit,visu,Clear;
    JTextField jt1,jt2,jt3;//jt4;
    JRadioButton bbtn,pbtn;
    JPanel jp1,jp2,jp3;
    JLabel l,l1,l2,l3;
    String a1;
    String[] a2 = new String[100]; // Or any appropriate size
    int[] a3 = new int[100]; // Or any appropriate size

    public visualisation1() {

        l = new JLabel("Data      Visualization");
        l.setBounds(30, 10, 650, 80);
        l.setFont(new Font("Osward", Font.BOLD, 60));
        l.setForeground(Color.BLACK);
        l.setLayout(null);
        add(l);

        jp1 = new JPanel();
        jp1.setBounds(0, 0, 190, 700);
        jp1.setBackground(Color.GRAY);

        l1 = new JLabel("Enter Your Data");
        l1.setBounds(10, 100, 160, 40);
        l1.setFont(new Font("Osward", Font.BOLD, 21));
        l1.setForeground(Color.BLACK);
        add(l1);



        jt1 = new JTextField();
        jt1.setBounds(10, 140, 170, 40);
        jt1.setText("Enter Graph Name");
        jt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(jt1.getText().equals("Enter Graph Name")){
                    jt1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jt1.getText().isEmpty()){
                    jt1.setText("Enter Graph Name");
                }
            }
        });
        jt1.setFont(new Font("Osward", Font.PLAIN, 20));
        jt1.setForeground(Color.BLACK);
        jt1.setBackground(Color.WHITE);
        add(jt1);

        jt2 = new JTextField();
        jt2.setBounds(10, 185, 170, 40);
        jt2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(jt2.getText().equals("Enter Y Values")){
                    jt2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jt2.getText().isEmpty()){
                    jt2.setText("Enter Y Values");
                }
            }
        });
        jt2.setFont(new Font("Osward", Font.PLAIN, 20));
        jt2.setForeground(Color.BLACK);
        jt2.setBackground(Color.WHITE);
        add(jt2);

        jt3 = new JTextField();
        jt3.setBounds(10, 230, 170, 40);
        jt3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(jt3.getText().equals("Enter X Labels")){
                    jt3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jt3.getText().isEmpty()){
                    jt3.setText("Enter X Labels");
                }
            }
        });
        jt3.setFont(new Font("Osward", Font.PLAIN, 20));
        jt3.setForeground(Color.BLACK);
        jt3.setBackground(Color.WHITE);
        add(jt3);

        bbtn = new JRadioButton("Bar Plot");
        bbtn.setBounds(20, 325, 130, 40);
        bbtn.setFont(new Font("osward", Font.BOLD, 25));
        bbtn.setForeground(Color.WHITE);
        bbtn.setBackground(Color.GRAY);
        add(bbtn);

        pbtn = new JRadioButton("Pie Plot");
        pbtn.setBounds(20, 375, 120, 40);
        pbtn.setFont(new Font("osward", Font.BOLD, 25));
        pbtn.setForeground(Color.WHITE);
        pbtn.setBackground(Color.GRAY);
        add(pbtn);

        ButtonGroup rbtn = new ButtonGroup();
        rbtn.add(bbtn);
        rbtn.add(pbtn);


        add(jp1);

        jp2 = new JPanel();
        jp2.setBounds(190, 0, 410, 600);
        add(jp2);

        visu = new JButton("Visualize!");
        visu.setBounds(201, 600, 140, 40);
        visu.setBackground(Color.BLACK);
        visu.setForeground(Color.WHITE);
        visu.setFont(new Font("Osward", Font.BOLD, 25));
        visu.setBorder(new LineBorder(Color.WHITE, 2));
        visu.addActionListener(this);
        visu.setLayout(null);
        add(visu);

        Clear = new JButton("Clear!");
        Clear.setBounds(350, 600, 120, 40);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.setFont(new Font("Osward", Font.BOLD, 25));
        Clear.setBorder(new LineBorder(Color.WHITE, 2));
        Clear.addActionListener(this);
        Clear.setLayout(null);
        add(Clear);

        quit = new JButton("EXIT!");
        quit.setBounds(480, 600, 100, 40);
        quit.setBackground(Color.BLACK);
        quit.setForeground(Color.WHITE);
        quit.setFont(new Font("Osward", Font.BOLD, 25));
        quit.setBorder(new LineBorder(Color.WHITE, 2));
        quit.addActionListener(this);
        quit.setLayout(null);
        add(quit);

        setTitle("Data Visualization Software");
        setSize(700, 700);
        setLayout(null);
        setResizable(true);
        setDefaultLookAndFeelDecorated(true);
        setUndecorated(true);
        setBackground(Color.WHITE);
        setLocation(200, 30);
        setVisible(true);
    }


    public  void actionPerformed(ActionEvent e){
        if (e.getSource()==quit){
            System.exit(1);
        } else if (e.getSource()==Clear) {
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");

        } else if (bbtn.isSelected() && e.getSource() == visu) {
            try {
                String a1 = jt1.getText();
                String[] a2 = jt2.getText().split(",");
                String[] a3 = jt3.getText().split(",");

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                // Populate dataset
                for (int i = 0; i < a2.length && i < a3.length; i++) {
                    int value;
                    try {
                        value = Integer.parseInt(a2[i].trim());
                    } catch (NumberFormatException ex) {
                        // Handle invalid number format
                        System.err.println("Invalid number format for value: " + a2[i]);
                        continue; // Skip this value and continue with the next one
                    }
                    dataset.addValue(value, "Value", a3[i].trim());
                }

                // Create chart
                JFreeChart chart = ChartFactory.createBarChart(a1, "Category", "Value", dataset, PlotOrientation.VERTICAL, false, false, false);

                // Customize chart appearance
                CategoryPlot catPlot = chart.getCategoryPlot();
                catPlot.setRangeGridlinePaint(Color.BLACK);

                // Display chart in a frame
                ChartFrame chartFrame = new ChartFrame(a1, chart);
                chartFrame.setVisible(true);
                chartFrame.setBounds(420,120,450,500);
                chartFrame.setSize(450, 500);
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }
        else if (pbtn.isSelected() && e.getSource()==visu) {
            try {
                a1 = String.valueOf(jt1.getText());
                String[] a2 = jt2.getText().split(","); // Splitting the input values separated by commas
                String[] a3 = jt3.getText().split(","); // Splitting the labels separated by commas

                DefaultPieDataset pieDataset = new DefaultPieDataset();
                for (int i = 0; i < a2.length; i++) {
                    try {
                        // Parsing each value and adding it to the dataset with the corresponding label
                        double value = Double.parseDouble(a2[i]);
                        pieDataset.setValue(a3[i], value);
                    } catch (NumberFormatException ex) {
                        // Handle the case where the value cannot be parsed as a double
                        System.err.println("Invalid value: " + a2[i]);
                        // You may choose to skip this value or handle it differently based on your requirements
                    }
                }

                JFreeChart chart = ChartFactory.createPieChart(a1, pieDataset, true, true, true);
                PiePlot piePlot = (PiePlot) chart.getPlot();

                ChartFrame chartFrame = new ChartFrame(a1, chart);
                chartFrame.setVisible(true);
                chartFrame.setBounds(420,120,450,500);
                chartFrame.setSize(450, 500);
            } catch (Exception ae) {
                System.out.println(ae);
            }

        }

    }
    public static void main(String[] args) {

        new visualisation1();
    }
}
