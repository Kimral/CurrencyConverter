package com.usue.svetlyakov.coursework.tools.currency;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CurrencyFetcher {
    static Map<LocalDate, Map<String, CurrencyData>> fetchedData = new HashMap<>();


    static private void FetchDataForDate(LocalDate date) {
        if(!fetchedData.containsKey(date))
            GetData(date);
    }

    static public Map<String, CurrencyData> GetForDate(LocalDate date) {
        FetchDataForDate(date);
        var result = fetchedData.get(date);
        CurrencyData ruble = new CurrencyData(
                0,
                "RUB",
                1,
                "Российский рубль",
                1,
                1
        );
        result.put("R0000", ruble);
        return result;
    }

    static private void GetData(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = date.format(formatter);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + dateString);
            Document document = builder.parse(url.openStream());

            NodeList currencies = document.getElementsByTagName("Valute");
            // Итерация по всем элементам
            AddCurrency(date, currencies);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static private void AddCurrency(LocalDate date, NodeList currencies) {
        Map<String, CurrencyData> dataForDate = new HashMap<>();
        for (int i = 0; i < currencies.getLength(); i++) {
            Element element = (Element) currencies.item(i);
            String id = element.getAttribute("ID");
            int numCode = Integer.parseInt(element.getElementsByTagName("NumCode").item(0).getTextContent());
            String charCode = element.getElementsByTagName("CharCode").item(0).getTextContent();
            int nominal = Integer.parseInt(element.getElementsByTagName("Nominal").item(0).getTextContent());
            String name = element.getElementsByTagName("Name").item(0).getTextContent();

            String valueStr = element.getElementsByTagName("Value").item(0).getTextContent().replace(',', '.');
            double value = Double.parseDouble(valueStr);

            String valueRateStr = element.getElementsByTagName("VunitRate").item(0).getTextContent().replace(',', '.');
            double valueRate = Double.parseDouble(valueRateStr);

            // Обработка каждого элемента, например, вывод его содержимого
            CurrencyData currency = new CurrencyData(numCode, charCode, nominal, name, value, valueRate);
            dataForDate.put(id, currency);
        }
        fetchedData.put(date, dataForDate);
    }
}
