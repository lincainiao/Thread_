import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.renameFile("E:\\FreeTool\\video\\2");
    }

    public void renameFile(String filePath){
        //目录
        File fileDir = new File(filePath);
        //获取目录下所有文件名
        String[] fileList = fileDir.list();
        //获取文件
        File file = null;
        //复制到新文件
        File newFile = null;
        for (int i = 0; i < fileList.length; i++) {
            //源文件
            file = new File(fileDir,fileList[i]);
            newFile = new File(fileDir,fileList[i].replaceAll(" ",""));
            file.renameTo(newFile);
        }
    }
}
