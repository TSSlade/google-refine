package com.google.refine.exporters;

import java.util.HashMap;
import java.util.Map;

abstract public class ExporterRegistry {
    static final private Map<String, Exporter> s_formatToExporter = new HashMap<String, Exporter>();

    static {
        s_formatToExporter.put("html", new HtmlTableExporter());
        s_formatToExporter.put("xls", new XlsExporter());
        s_formatToExporter.put("csv", new CsvExporter());
        
        s_formatToExporter.put("template", new TemplatingExporter());
    }
    
    static public void registerExporter(String format, Exporter exporter) {
        s_formatToExporter.put(format.toLowerCase(), exporter);
    }
    
    static public Exporter getExporter(String format) {
        return s_formatToExporter.get(format.toLowerCase());
    }
}