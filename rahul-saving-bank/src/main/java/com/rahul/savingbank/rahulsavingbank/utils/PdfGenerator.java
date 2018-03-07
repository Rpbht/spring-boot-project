package com.rahul.savingbank.rahulsavingbank.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> arg0, Document arg1, PdfWriter arg2, HttpServletRequest arg3,
			HttpServletResponse arg4) throws Exception {
		Paragraph header = new Paragraph(
				new Chunk("Your Transactions Statement", FontFactory.getFont(FontFactory.HELVETICA, 30)));
		Paragraph by = new Paragraph(new Chunk("Author ",
				FontFactory.getFont(FontFactory.HELVETICA, 20)));
	}

}
