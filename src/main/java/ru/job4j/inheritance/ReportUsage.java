package ru.job4j.inheritance;

import ru.job4j.inheritance.TextReport;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();

        JSONReport rep = new JSONReport();
        String text0 = rep.generate("Report's name", "Report's body");
        System.out.println(text0);
    }
}
