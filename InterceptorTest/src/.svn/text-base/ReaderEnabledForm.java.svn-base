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
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ReaderEnabledForm {

    /** The original PDF. */
    public static final String RESOURCE = "C:/Users/Mike.Mai/Desktop/xfa_enabled.pdf";
    /** The resulting PDF. */
//    public static final String RESULT1 = "E:/work/xfa_broken.pdf";
//    /** The resulting PDF. */
//    public static final String RESULT2 = "E:/work/xfa_removed.pdf";
    /** The resulting PDF. */
    public static final String RESULT3 = "E:/work/xfa_preserved.pdf";
    public static final String[] LANGUAGES = {  "German", "French", "Spanish", "Dutch" };


    /**
     * Manipulates a PDF file src with the file dest as result
     * @param src the original PDF
     * @param dest the resulting PDF
     * @throws IOException
     * @throws DocumentException
     */
    public void manipulatePdf(final String src, final String dest, final boolean remove, final boolean preserve)
        throws IOException, DocumentException {
        // create the reader
        final PdfReader reader = new PdfReader(src);
        // remove the usage rights (or not)
        if (remove) {
            reader.removeUsageRights();
        }
        // create the stamper
        PdfStamper stamper;
        // preserve the reader enabling by creating a PDF in append mode (or not)
        if (preserve) {
            stamper = new PdfStamper(reader, new FileOutputStream(dest), '\0', true);
        } else {
            stamper = new PdfStamper(reader, new FileOutputStream(dest));
        }
        // fill out the fields
        final AcroFields form = stamper.getAcroFields();
        form.setField("movie[0].#subform[0].title[0]", "The Misfortunates");
        form.setField("movie[0].#subform[0].original[0]", "Dp");
        form.setField("movie[0].#subform[0].duration[0]", "188888");
        form.setField("movie[0].#subform[0].year[0]", "2009");
        form.setField("name", "mike");
/*
        final PdfContentByte canvas = stamper.getOverContent(1);
        ColumnText.showTextAligned(canvas,
        Element.ALIGN_LEFT, new Phrase("Hello people!"), 36, 540, 0);
        */


/*        stamper.setRotateContents(false);
        final PdfContentByte canvas = stamper.getOverContent(1);
        ColumnText.showTextAligned(canvas,
        Element.ALIGN_LEFT, new Phrase("Hello people!"), 36, 540, 0);
        */

      /*  final AcroFields form2 = stamper.getAcroFields();
        final PushbuttonField ad
        = form2.getNewPushbuttonFromField("advertisement");
        ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
        ad.setProportionalIcon(true);
        ad.setImage(Image.getInstance(RESOURCE));
        form.replacePushbuttonField("advertisement", ad.getField());
        stamper.close();
        */


        // close the stamper
        stamper.close();
        reader.close();
    }

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     * @throws DocumentException
     */
    public static void main(final String[] args) throws IOException, DocumentException,
        ParserConfigurationException, SAXException,
        TransformerFactoryConfigurationError, TransformerException {
        final ReaderEnabledForm form = new ReaderEnabledForm();
 //       form.manipulatePdf(RESOURCE, RESULT1, false, false);
//        form.manipulatePdf(RESOURCE, RESULT2, true, false);
        form.manipulatePdf(RESOURCE, RESULT3, false, true);
    }
}
