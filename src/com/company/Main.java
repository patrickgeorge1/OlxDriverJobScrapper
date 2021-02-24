package com.company;

import com.company.document_parsers.OlxDocumentParser;
import com.company.utils.HttpRequestType;
import com.company.utils.Job;
import com.company.utils.WebsiteDownloader;
import com.company.vendors.OlxVendor;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO: for each vendor

        // Get list of URL for custom vendor
        OlxVendor olxVendor = new OlxVendor();
        ArrayList<String> urls = olxVendor.getValidURL();

        for (String url : urls) {
            // For each URL download website
            WebsiteDownloader wd = new WebsiteDownloader(url, HttpRequestType.GET);
            Document doc = wd.download();

            // Parse and get job info
            OlxDocumentParser olxDP = new OlxDocumentParser();
            Job job = olxDP.parse(doc);
            System.out.println(job);
        }


    }
}
