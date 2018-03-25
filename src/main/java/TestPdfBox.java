import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class TestPdfBox {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/cuizhichao/Desktop/a.pdf");
        PDDocument doc=PDDocument.load(file);
        int pagenumber=doc.getNumberOfPages();
        System.out.print("pages"+pagenumber);
        FileOutputStream fos=new FileOutputStream("/Users/cuizhichao/Desktop/a.doc");
        Writer writer=new OutputStreamWriter(fos);
        PDFTextStripper stripper=new PDFTextStripper();
        stripper.setSortByPosition(true);//排序
        stripper.setStartPage(1);//设置转换的开始页
        stripper.setEndPage(pagenumber);//设置转换的结束页
        stripper.writeText(doc,writer);
        writer.close();
        doc.close();
    }
}