package com.company.vendors;

import com.company.utils.Constants;
import com.company.utils.HttpRequestType;
import com.company.utils.WebsiteDownloader;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlxVendor implements Vendor {
    private final String root_url = Constants.olx_root_website;



    @Override
    public ArrayList<String> getValidURL() throws IOException {
        ArrayList<String> urls = new ArrayList<>();
        ArrayList<String> allPageURLs = getAllPageURLs();

        for (String pageUrl:allPageURLs) {
            ArrayList<String> addsURL = getAdsFromPage(pageUrl);
            urls.addAll(addsURL);
        }
        return urls;
    }

    public  ArrayList<String> getAllPageURLs() throws IOException {
        ArrayList<String> page_urls = new ArrayList<>();

        int page = 0;
        while (true) {
            page++;
            String page_url = root_url.replaceAll("@", String.valueOf(page));
            page_urls.add(page_url);
            if (!checkIfNextPageExists(page_url, page + 1)) break;
        }
        return page_urls;
    }

    public boolean checkIfNextPageExists(String page_url, Integer expectedNextPage) throws IOException {
        // get page
        WebsiteDownloader wd = new WebsiteDownloader(page_url, HttpRequestType.GET);
        Document doc = wd.download();

        // Search for next page
        Elements nextPage = doc.getElementsByClass("link pageNextPrev {page:" + expectedNextPage + "}");
        return (nextPage.size() != 0) && (nextPage.get(0).tagName().equals("a"));
    }

    public ArrayList<String> getAdsFromPage(String pageURL) throws IOException {
        List<String> ads = new ArrayList<>();

        WebsiteDownloader wd = new WebsiteDownloader(pageURL, HttpRequestType.GET);
        Document doc = wd.download();
        ads =  doc.getElementsByTag("a")
                .stream()
                .filter(element -> element.attr("data-cy").equals("listing-ad-title"))
                .map(element -> element.attr("href"))
                .collect(Collectors.toList());

        return (ArrayList<String>) ads;
    }
}
