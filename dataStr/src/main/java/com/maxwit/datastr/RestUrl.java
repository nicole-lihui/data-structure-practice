package com.maxwit.datastr;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestUrl {

    public String getUrl(String urlTem, Map pa) {
        Object org = pa.get("org");
        Object repo = pa.get("repo");
        Object owner = pa.get("owner");

        String regex = "(:(\\w+))";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(urlTem);

        String ur = urlTem;
        while(m.find()){
            switch (m.group(2)) {
                case "org":
                    try {
                        ur = ur.replace(m.group(1), (CharSequence) org);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    break;

                case "repo":
                    try {
                        ur = ur.replace(m.group(1), (CharSequence) repo);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    break;
                case "owner":
                    try {
                        ur = ur.replace(m.group(1), (CharSequence) owner);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }

        return ur;
    }
}
