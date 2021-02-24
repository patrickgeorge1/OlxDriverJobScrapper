package com.company.utils;

import com.company.utils.HttpRequestType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteDownloader {
    private String URL = "";
    private HttpRequestType method = HttpRequestType.GET;

    public Document download() throws IOException {
        if (!isValidURL()) throw new IOException("URL specified is invalid");
        Document doc;
        switch (method) {
            case GET:
                doc = Jsoup.connect(URL).get();
                break;
            case POST:
                doc = Jsoup.connect(URL).post();
                break;
            default:
                throw new IOException("request type -" + method + "- not supported");
        }
        doc.selectFirst("head").child(0).before("<url>" + URL + "</url>");
        return doc;
    }


    public WebsiteDownloader() {}

    public WebsiteDownloader(String URL) {
        this.URL = URL;
    }

    public WebsiteDownloader(String URL, HttpRequestType method) {
        this.URL = URL;
        this.method = method;
    }

    public Boolean isValidURL() {
        return !URL.equals("");
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public HttpRequestType getMethod() {
        return method;
    }

    public void setMethod(HttpRequestType method) {
        this.method = method;
    }
}
