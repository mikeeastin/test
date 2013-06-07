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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RadioCheckField;
import com.itextpdf.text.pdf.TextField;
public class TextFields implements PdfPCellEvent {

    /** The resulting PDF. */
    public static final String RESULT1 = "E:/work/08.pdf";

    /** The text field index of a TextField that needs to be added to a cell. */
    protected int tf;
    public static final String[] LANGUAGES = {  "German", "French", "Spanish", "Dutch" };

    /**
     * Creates a cell event that will add a text field to a cell.
     * @param tf a text field index.
     */
    public TextFields(final int tf) {
        this.tf = tf;
    }



    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(final String filename) throws DocumentException, IOException {
        // step 1
        final Document document = new Document();
        // step 2
        final PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();

        // step 4
        //add radio
        final PdfContentByte canvas = writer.getDirectContent();
        final Font font = new Font(FontFamily.HELVETICA, 18);
        Rectangle rect;
        PdfFormField field;
        final PdfFormField radiogroup = PdfFormField.createRadioButton(writer, true);
        radiogroup.setFieldName("language");
        RadioCheckField radio;
        //add all radios
        for (int i = 0; i < LANGUAGES.length; i++) {
            rect = new Rectangle(40, 806 - i * 40, 60, 788 - i * 40);
            radio = new RadioCheckField(writer, rect, null, LANGUAGES[i]);
            radio.setCheckType(RadioCheckField.TYPE_CIRCLE);
            field = radio.getRadioField();
            radiogroup.addKid(field);
          ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
         new Phrase(LANGUAGES[i], font), 70, 790 - i * 40, 0);
        }
        writer.addAnnotation(radiogroup);

        //  Add the check boxes
         RadioCheckField checkbox;
        for (int i = 0; i < LANGUAGES.length; i++) {
            rect = new Rectangle(180, 806 - i * 40, 200, 788 - i * 40);
            checkbox = new RadioCheckField(writer, rect, LANGUAGES[i], "on");
            field = checkbox.getCheckField();
            writer.addAnnotation(field);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                new Phrase(LANGUAGES[i], font), 210, 790 - i * 40, 0);
        }


        //add table
        PdfPCell cell;
        final PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{1,1});
        table.addCell("Name:");
        cell = new PdfPCell();
        final TextFields tfs = new TextFields(1);
        cell.setCellEvent(tfs);
        table.addCell(cell);
        table.setTotalWidth(0.8f);
        table.setHorizontalAlignment(2);
        document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n"));
        document.add(table);

        // step 5
        document.close();

    }

    /**
     * Creates and adds a text field that will be added to a cell.
     * @see com.itextpdf.text.pdf.PdfPCellEvent#cellLayout(com.itextpdf.text.pdf.PdfPCell,
     *      com.itextpdf.text.Rectangle, com.itextpdf.text.pdf.PdfContentByte[])
     */
    @Override
    public void cellLayout(final PdfPCell cell, final Rectangle rectangle, final PdfContentByte[] canvases) {
        final PdfWriter writer = canvases[0].getPdfWriter();
        final TextField text = new TextField(writer, rectangle,
                String.format("text_%s", tf));
        switch(tf) {
        case 1:
            text.setText("Enter name here...");
            text.setFontSize(0);
            text.setAlignment(Element.ALIGN_CENTER);
            text.setOptions(TextField.REQUIRED);
            break;
              }
        try {
            final PdfFormField field = text.getTextField();
            writer.addAnnotation(field);
        }
        catch(final IOException ioe) {
            throw new ExceptionConverter(ioe);
        }
        catch(final DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    /**
     * Main method
     * @param args no arguments needed
     * @throws IOException
     * @throws DocumentException
     */
    public static void main(final String[] args) throws DocumentException, IOException {
        final TextFields example = new TextFields(0);
        example.createPdf(RESULT1);
    }
}
