package gui;

import client.Client;
import client.ClientDataBuilder;
import client.DUL;
import converter.Converter;
import converter.ConvertionData;
import converter.ConvertionResult;
import enums.CURRENCY_ENUM;
import exception.PrintException;
import services.DbService;
import util.Printer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private DbService service;
    private JButton ok, addNewClient, createReaquest;
    private JTextField fName, sName, lName, inputAmmountField, dulType, dulNumber, dulFullname;
    private JPanel buttonPanel, convData, clientData;
    private JComboBox<CURRENCY_ENUM> inputCurrency, outputCurrency;
    private JComboBox<Object> client;
    private DefaultComboBoxModel<Object> clientModel = new DefaultComboBoxModel<>();
    private Client clients;
    public GUI() {
        super("Converter");
        setDefaultLookAndFeelDecorated(false);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    private void init() {
        service = new DbService();
        JPanel mainPanel = new JPanel();
        DefaultComboBoxModel<CURRENCY_ENUM> cbm1 = new DefaultComboBoxModel<>();
        cbm1.addElement(CURRENCY_ENUM.USD);
        cbm1.addElement(CURRENCY_ENUM.RUB);
        DefaultComboBoxModel<CURRENCY_ENUM> cbm2 = new DefaultComboBoxModel<>();
        cbm2.addElement(CURRENCY_ENUM.USD);
        cbm2.addElement(CURRENCY_ENUM.RUB);

        client = new JComboBox();
        client.setModel(clientModel);

        inputCurrency = new JComboBox<>(cbm1);
        outputCurrency = new JComboBox<>(cbm2);

        ok = new JButton("Submit");
        ok.addActionListener(new ConvertationRequestListener());
        addNewClient = new JButton("Add New Client");
        addNewClient.addActionListener(new CreateNewClient());
        createReaquest = new JButton("createRequest");
        createReaquest.addActionListener(new CreqateRequest());
        clientData = new JPanel();


        fName = new JTextField(9);
        fName.setText("Иван");
        lName = new JTextField(9);
        lName.setText("Иванович");
        sName = new JTextField(9);
        sName.setText("Иванов");
        dulNumber = new JTextField(9);
        dulNumber.setText("464512354");
        dulType = new JTextField(9);
        dulType.setText("Passport");
        clientData.setLayout(new BoxLayout(clientData, BoxLayout.Y_AXIS));
        clientData.add(new JLabel("Фамилия"));
        clientData.add(sName, BorderLayout.WEST);
        clientData.add(new JLabel("Имя"));
        clientData.add(fName, BorderLayout.WEST);
        clientData.add(new JLabel("Отчество"));
        clientData.add(lName, BorderLayout.WEST);
        clientData.add(new JLabel("Тип документа"));
        clientData.add(dulType, BorderLayout.WEST);
        clientData.add(new JLabel("номер документа"));
        clientData.add(dulNumber, BorderLayout.WEST);

        inputAmmountField = new JTextField(9);
        buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(ok);

        convData = new JPanel();
        convData.add("client", client);
        convData.add("Исходная сумма для конвертации", inputAmmountField);
        convData.add("Исходная валюта", inputCurrency);
        convData.add("Целевая валюта", outputCurrency);

        mainPanel.add(addNewClient);
        mainPanel.add(createReaquest);

        getContentPane().add(mainPanel);

    }


    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            service = new DbService();
            StringBuilder sb = new StringBuilder();

            sb.append(sName.getText().trim()).append(" ")
                    .append(fName.getText().trim()).append(" ")
                    .append(lName.getText().trim());
            System.out.println(sb.toString());

            clients = new ClientDataBuilder().builData(new DUL(dulType.getText(),
                    Integer.parseInt(dulNumber.getText()),
                    sb.toString().trim()));
            service.createClient(1, clients);
            clientModel.addElement(service.getClientById(1));

            lName.setText("");
            fName.setText("");
            sName.setText("");
            dulNumber.setText("");
            dulType.setText("");


        }
    }

    private class CreateNewClient implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton ok = new JButton("OK");
            ok.addActionListener(new SubmitListener());
            JDialog window = new JDialog();
            window.setVisible(true);
            window.setBounds(80, 200, 350, 250);
            window.add(clientData, BorderLayout.WEST);
            window.add(ok, BorderLayout.SOUTH);
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            window.setResizable(false);
        }
    }

    private class CreqateRequest implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            JDialog dialog = new JDialog();
            dialog.setBounds(1000, 200, 450, 250);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dialog.add(convData, BorderLayout.NORTH);
            dialog.add(buttonPanel, BorderLayout.SOUTH);
            dialog.repaint();
            dialog.setVisible(true);

        }
    }

    private class ConvertationRequestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            ConvertionData data = new ConvertionData(service.getClientById(1), Double.valueOf(inputAmmountField.getText()),
                    inputCurrency.getSelectedItem(),outputCurrency.getSelectedItem());
            ConvertionResult result = new Converter().convert(data);
            try {
                JOptionPane.showMessageDialog(null, Printer.print(result));
            } catch (PrintException e1) {
                e1.printStackTrace();
            }

        }
    }
}