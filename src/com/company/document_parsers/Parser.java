package com.company.document_parsers;

import com.company.utils.Job;
import org.jsoup.nodes.Document;


public interface Parser {
    Job parse(Document doc);
}
