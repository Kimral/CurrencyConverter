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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CurrencyFetcher {
    Map<Date, Vector<CurrencyData>> fetchedData;

    public CurrencyFetcher() {
        fetchedData = new HashMap<>();
    }

    private void FetchDataForDate(Date date) {
        if(!fetchedData.containsKey(date))
            GetData(date);
    }

    public Vector<CurrencyData> GetForDate(Date date) {
        FetchDataForDate(date);
        return fetchedData.get(date);
    }

    private void GetData(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatter.format(date);

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

    private void AddCurrency(Date date, NodeList currencies) {
        Vector<CurrencyData> dataForDate = new Vector<>();
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
            CurrencyData currency = new CurrencyData(id, numCode, charCode, nominal, name, value, valueRate);
            dataForDate.add(currency);
        }
        fetchedData.put(date, dataForDate);
    }
}
