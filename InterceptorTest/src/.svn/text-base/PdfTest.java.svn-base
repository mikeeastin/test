    import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

// Copyright (c) 1998-2013 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2013-XX-XX, Mike.Mai, creation
// ============================================================================

/**
 * @author Mike.Mai
 *
 */

 public class PdfTest
 {
     public static void main(final String[] args) throws Exception{

    }


     public static void test01() throws FileNotFoundException, DocumentException{
         final Document pdfDoc = new Document();
         // 将要生成的 pdf 文件的路径输出流
         final FileOutputStream pdfFile =
             new FileOutputStream(new File("E:/work/firstPdf01.pdf"));

         // pdf 文件中的一个文字段落
         final Paragraph paragraph = new Paragraph("My first PDF file with an image ...");
         //final Image image = Image.getInstance("F:/study/test/洛克 李.jpg");

        // 用 Document 对象、File 对象获得 PdfWriter 输出流对象
        PdfWriter.getInstance(pdfDoc, pdfFile);
        pdfDoc.open();  // 打开 Document 文档

        // 添加一个文字段落、一张图片
        pdfDoc.add(paragraph);
      // pdfDoc.add(image);

        pdfDoc.close();
     }
     public static  void test02(){

     }
  }
