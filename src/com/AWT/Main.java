package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main(){ // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args){
        Main  myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showListDemo(); // и вызываемый метод showListDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI(){
        mainFrame = new Frame("Java AWT List");  // инициализация фрэйма
        mainFrame.setSize(400,400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener( new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent){ // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350,100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в List
    private void showListDemo(){

        headerLabel.setText("Контрол в действии: List");
        final List fruitList = new List(4,false); // создание List

        fruitList.add("Яблоко"); // добавление объектов в List
        fruitList.add("Курага");
        fruitList.add("Манго");
        fruitList.add("Банан");

        // создание List 2
        final List vegetableList = new List(4,true);

        vegetableList.add("Морковка"); // добавление объектов в List 2
        vegetableList.add("Картошка");
        vegetableList.add("Помидор");
        vegetableList.add("Баклажан");

        Button showButton = new Button("Показать"); // создание кнопки

        showButton.addActionListener(new ActionListener() { // действие при активации кнокпи

            public void actionPerformed(ActionEvent e) {
                String data = "Выбранный фрукт: " // записываем в первую строку наш выбранный фрукт
                        + fruitList.getItem(fruitList.getSelectedIndex());
                data += ", Выбранный овощ: "; // и так же выбранные овоши из второго списка
                for(String vegetable:vegetableList.getSelectedItems()){
                    data += vegetable + " ";
                }
                statusLabel.setText(data); // вывести на лэйбл
            }
        });

        // добавление объектов на форму
        controlPanel.add(fruitList);
        controlPanel.add(vegetableList);
        controlPanel.add(showButton);

        // видимость формы true
        mainFrame.setVisible(true);
    }
}
