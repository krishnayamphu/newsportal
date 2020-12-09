package com.aptech.helpers;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MediaHelper {
    private ServletContext myContext;

    public MediaHelper(ServletContext context){
        this.myContext=context;
    }


    //all media files
    public  List<String> getMediaList() {
        List<String> allFileList = new ArrayList<>();
        String root = myContext.getRealPath("/");
        File path = new File(root + "/uploads");
        File[] allFiles = path.listFiles();
        if (allFiles != null) {
            for (File f : allFiles) {
                allFileList.add(f.getName());
                System.out.println(f.getName());
            }
        }
        return allFileList;
    }
}
