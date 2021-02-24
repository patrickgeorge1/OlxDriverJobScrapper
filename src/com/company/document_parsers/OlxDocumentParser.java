package com.company.document_parsers;

import com.company.utils.Job;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.stream.Collectors;

public class OlxDocumentParser implements Parser {
    @Override
    public Job parse(Document doc) {
        Elements metaTags = doc.getElementsByTag("meta");

        String title = doc.title();
        String description = metaTags
                .stream()
                .filter(meta -> meta.attr("name").equals("description"))
                .map(element -> element.attr("content"))
                .reduce("", (partialString, element) -> partialString + element);
        String url = doc.getElementsByTag("url")
                .stream()
                .map(element -> element.text())
                .reduce("", (partialString, element) -> partialString + element);
        String phone = "impossible";
        String author = "impossible";

        return new Job(author, phone, title, description, url);
    }

    public OlxDocumentParser() {}
}
