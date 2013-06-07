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
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfBorderDictionary;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PushbuttonField;
import com.itextpdf.text.pdf.RadioCheckField;

public class Buttons {

    /** The resulting PDF. */
    public static final String RESULT1 = "E:/work/buttons.pdf";
    /** The resulting PDF. */
    public static final String RESULT2 = "E:/work/buttons_filled.pdf";
    /** Path to a JavaScript resource. */
  //  public static final String RESOURCE = "resources/js/buttons.js";
    /** Path to an image used as button icon. */
   // public static final String IMAGE = "resources/img/info.png";
    /** Possible values of a radio field / checkboxes */
    public static final String[] LANGUAGES = { "English", "German", "French", "Spanish", "Dutch" };

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(final String filename) throws IOException, DocumentException {
        // step 1
        final Document document = new Document();
        // step 2
        final PdfWriter writer =
            PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        // add the JavaScript
      //  writer.addJavaScript(Utilities.readFileToString(RESOURCE));
        // add the radio buttons
        final PdfContentByte canvas = writer.getDirectContent();
        final Font font = new Font(FontFamily.HELVETICA, 18);
        Rectangle rect;
        PdfFormField field;
        final PdfFormField radiogroup = PdfFormField.createRadioButton(writer, true);
        radiogroup.setFieldName("language");
        RadioCheckField radio;
        for (int i = 0; i < LANGUAGES.length; i++) {
            rect = new Rectangle(40, 806 - i * 40, 60, 788 - i * 40);
            radio = new RadioCheckField(writer, rect, null, LANGUAGES[i]);
            radio.setBorderColor(GrayColor.GRAYBLACK);
            radio.setBackgroundColor(GrayColor.GRAYWHITE);
            radio.setCheckType(RadioCheckField.TYPE_CIRCLE);
            field = radio.getRadioField();
            radiogroup.addKid(field);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                new Phrase(LANGUAGES[i], font), 70, 790 - i * 40, 0);
        }
        writer.addAnnotation(radiogroup);
        // Add the check boxes
        final PdfAppearance[] onOff = new PdfAppearance[2];
        onOff[0] = canvas.createAppearance(20, 20);
        onOff[0].rectangle(1, 1, 18, 18);
        onOff[0].stroke();
        onOff[1] = canvas.createAppearance(20, 20);
        onOff[1].setRGBColorFill(255, 128, 128);
        onOff[1].rectangle(1, 1, 18, 18);
        onOff[1].fillStroke();
        onOff[1].moveTo(1, 1);
        onOff[1].lineTo(19, 19);
        onOff[1].moveTo(1, 19);
        onOff[1].lineTo(19, 1);
        onOff[1].stroke();
        RadioCheckField checkbox;
        for (int i = 0; i < LANGUAGES.length; i++) {
            rect = new Rectangle(180, 806 - i * 40, 200, 788 - i * 40);
            checkbox = new RadioCheckField(writer, rect, LANGUAGES[i], "on");
            field = checkbox.getCheckField();
            field.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, "Off", onOff[0]);
            field.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, "On", onOff[1]);
            writer.addAnnotation(field);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                new Phrase(LANGUAGES[i], font), 210, 790 - i * 40, 0);
        }
        // Add the push button
        rect = new Rectangle(300, 806, 370, 788);
        final PushbuttonField button = new PushbuttonField(writer, rect, "Buttons");
        button.setBackgroundColor(new GrayColor(0.75f));
        button.setBorderColor(GrayColor.GRAYBLACK);
        button.setBorderWidth(1);
        button.setBorderStyle(PdfBorderDictionary.STYLE_BEVELED);
        button.setTextColor(GrayColor.GRAYBLACK);
        button.setFontSize(12);
        button.setText("Push me");
        button.setLayout(PushbuttonField.LAYOUT_ICON_LEFT_LABEL_RIGHT);
        button.setScaleIcon(PushbuttonField.SCALE_ICON_ALWAYS);
        button.setProportionalIcon(true);
        button.setIconHorizontalAdjustment(0);
      //  button.setImage(Image.getInstance(IMAGE));
        field = button.getField();
        field.setAction(PdfAction.javaScript("this.showButtonState()", writer));
        writer.addAnnotation(field);
        // step 5
        document.close();

    }

    /**
     * Manipulates a PDF file src with the file dest as result
     * @param src the original PDF
     * @param dest the resulting PDF
     * @throws IOException
     * @throws DocumentException
     */
    public void manipulatePdf(final String src, final String dest) throws IOException, DocumentException {
        final PdfReader reader = new PdfReader(src);
        final PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        final AcroFields form = stamper.getAcroFields();
        final String[] radiostates = form.getAppearanceStates("language");
        form.setField("language", radiostates[4]);
        for (int i = 0; i < LANGUAGES.length; i++) {
            final String[] checkboxstates = form.getAppearanceStates("English");
            form.setField(LANGUAGES[i], checkboxstates[i % 2 == 0 ? 1 : 0]);
        }
        stamper.close();
        reader.close();
    }

    /**
     * Main method
     * @param args no arguments needed
     * @throws IOException
     * @throws DocumentException
     */
    public static void main(final String[] args) throws IOException, DocumentException {
        final Buttons buttons = new Buttons();
        buttons.createPdf(RESULT1);
        buttons.manipulatePdf(RESULT1, RESULT2);
    }
}
