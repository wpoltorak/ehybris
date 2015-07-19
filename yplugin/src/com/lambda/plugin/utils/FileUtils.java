package com.lambda.plugin.utils;

import java.io.File;
import java.io.FileFilter;

public class FileUtils {

    public static File[] listFolders(File folder) {
        File[] folders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        return folders;
    }

}
