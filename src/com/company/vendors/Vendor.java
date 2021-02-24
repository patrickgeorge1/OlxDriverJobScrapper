package com.company.vendors;

import java.io.IOException;
import java.util.ArrayList;

public interface Vendor {
    public ArrayList<String> getValidURL() throws IOException;
}
