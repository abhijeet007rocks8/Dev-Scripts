package com.tridib;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class App {
    public static String getData(String country) throws Exception {
        StringBuffer br =new StringBuffer();
        br.append("<html>");
        br.append(country.toUpperCase() + "<br>");

        String url = "https://www.worldometers.info/coronavirus/country/" + country + "/";
        Document doc = Jsoup.connect(url).get();//get returns all the html file from the url
        //#maincounter-wrap
        Elements elements = doc.select("#maincounter-wrap");
        elements.forEach((e) -> {
            String text = e.select("h1").text();
            String count = e.select(".maincounter-number>span").text();
            br.append(text).append(count).append("<br>");
        });
        br.append("</html>");
            return br.toString();
    }

    public static void main(String[] args) throws Exception {

        //do {
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("Enter country");
//            String c= sc.next();
//            if(c.equals("stop"))
//            {
//                break;
//            }
//        System.out.println(getData(c));




        // GUI PART



        JFrame root = new JFrame("Details of Country");
        root.setSize(500,500);

        Font f = new Font("Poppins",Font.BOLD,30);

        //text part

        JTextField field = new JTextField();

        //label
        JLabel dataL = new JLabel();
        field.setFont(f);
        dataL.setFont(f);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        dataL.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Get");
        button.addActionListener(event->{
            //when clicked use this part
            try{
                String maindata= field.getText();
                String result = getData(maindata);
                dataL.setText(result);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        });
        button.setFont(f);
        root.setLayout(new BorderLayout());

        root.add(field,BorderLayout.NORTH);
        root.add(dataL,BorderLayout.CENTER);
        root.add(button,BorderLayout.SOUTH);

        root.setVisible(true);





        }
//        while (true);
    }

