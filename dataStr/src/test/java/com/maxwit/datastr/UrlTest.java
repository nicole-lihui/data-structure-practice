package com.maxwit.datastr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UrlTest {

    @Test
    public void RestUrlTests() {
        RestUrl rurl = new RestUrl();
        String org = "aa";
        String repo = "bb";
        String owner = "cc";
        Map<String, String> info = new HashMap<>();
        info.put("repo", "repoaaa");
        info.put("owner", "112");

        String url1 = rurl.getUrl("/orgs/:repo/:org/:owner/repos/:oo/cecd", info);
        System.out.println(url1);
    }
}
