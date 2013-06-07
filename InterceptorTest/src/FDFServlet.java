/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.FdfReader;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class FDFServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
            "inline; filename=\"your.pdf\"");
        try {
            // Create a reader that interprets the request's input stream
            final FdfReader fdf = new FdfReader(request.getInputStream());
            // We get a resource from our web app
            final InputStream is
                = getServletContext().getResourceAsStream("subscribe.pdf");
            // We create a reader with the InputStream
            final PdfReader reader = new PdfReader(is, null);
            // We create an OutputStream for the new PDF
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // Now we create the PDF
            final PdfStamper stamper = new PdfStamper(reader, baos);
            // We alter the fields of the existing PDF
            final AcroFields fields = stamper.getAcroFields();
            fields.setFields(fdf);
            stamper.setFormFlattening(true);
            // close the stamper
            stamper.close();
            reader.close();
            // We write the PDF bytes to the OutputStream
            final OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
        } catch (final DocumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 2157128985625139848L;

}
