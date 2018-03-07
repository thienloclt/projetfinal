package monprojet.factory.Planning.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import monprojet.factory.dao.FormationDao;
import monprojet.factory.entity.Formation;
import monprojet.factory.entity.Planning;

public class GenSimpleReportVersionOK {

	public static ByteArrayInputStream simpleReport(List<Planning> modules) {

		Document document = new Document();
		// GenSimpleReport creates PDF file from the provided data.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		FormationDao d = null ;
		Formation f = d.find(1);
		f.getDateDebut();
		f.getDateFin();
		
		String dateDebut = "18-01-2018";
		String dateFin = "28-01-2018";
		////////////duree de la formation////////àsupp///////////
		
		try {
			String DATE_FORMAT = "dd-MM-yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			Date date1;
			date1 = (Date) sdf.parse(dateDebut);
			Date date2 = (Date) sdf.parse(dateFin);
			
			long jrs_formation = ((date2.getTime() - date1.getTime()) / 86400000) + 1;
			System.out.println("duree de la formation : "+jrs_formation);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//////////àsupp/////////////
		
		TraitementDate tDate = new TraitementDate();
		List<DateFormatee> listDateF = new ArrayList<DateFormatee>();
		try {
			listDateF = tDate.formaterDate(dateDebut, dateFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<jourFormation> listeJourFormation = new ArrayList<jourFormation>();
		for (DateFormatee dateFormatee : listDateF) {
			if (dateFormatee.getNom_jour().equals("sam") || dateFormatee.getNom_jour().equals("dim")) {
				listeJourFormation.add(new jourFormation(dateFormatee.getNom_mois_Maj(), dateFormatee.getNom_jour(),
						Integer.toString(dateFormatee.getDate_jour()), "", "", "", "#d9d9d9"));
			} else {
				listeJourFormation.add(new jourFormation(dateFormatee.getNom_mois_Maj(), dateFormatee.getNom_jour(),
						Integer.toString(dateFormatee.getDate_jour())));
			}
		}
		int indice = 0;
		boolean weekend = false;
		for (int j = 0; j < modules.size(); j++) {
			if (weekend) {
				j--;
			}
			// System.out.println("matiere = " + modules.get(j).getNom());
			int duree = modules.get(j).getDuree();
			weekend = false;

			// System.out.println("duree = " + duree);

			for (int i = 1; i <= duree; i++) {

				// System.out.println("jour = " + listeJourFormation.get(indice).getJour());
				if (listeJourFormation.get(indice).getJour().equals("sam")
						|| listeJourFormation.get(indice).getJour().equals("dim")) {
					duree = 2;
					// System.out.println("c'est un weekend");
					weekend = true;

				} else {

					// System.out.println("ce n'est pas un weekend " +
					// listeJourFormation.get(indice).getJour());
					listeJourFormation.get(indice).setMatiere(modules.get(j).getNom());
					listeJourFormation.get(indice).setFormateur(modules.get(j).getFormateur());
					listeJourFormation.get(indice).setTitre(modules.get(j).getTitreFormateur());
					listeJourFormation.get(indice).setCouleur(modules.get(j).getCouleur());
				}
				indice++;
			}
		}
	for (jourFormation jourFormation : listeJourFormation) {
			System.out.println("******* : " + jourFormation.toString());
		}
		//////////////////////////////////////// debut du tableau///////////////

		try {
			// We will put our data in a table; for this, we have the PdfPTable class. 
			PdfPTable mytable = new PdfPTable(6);
			mytable.setWidthPercentage(90);
			mytable.setWidths(new int[] { 2, 2, 1, 8, 4, 4 });
		//	mytable.completeRow();

			// For the table header, we use bold Helvetica font.
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			// The data is placed inside table cells, represented by PdfPCell. The text is
			// horizontally aligned using the setHorizontalAlignment() method.
			PdfPCell hcell;

			// **********************************************************************************header
			hcell = new PdfPCell(new Phrase("Mois", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			mytable.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(2);
			mytable.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Module", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			mytable.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Formateur", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			mytable.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Titre", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			mytable.addCell(hcell);
			// *******************************************************************fin header

			for (jourFormation jourFormation : listeJourFormation) {
				System.out.println("list des jours*******"+jourFormation.toString());

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(jourFormation.getMois()));
				// cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mytable.addCell(cell);

				cell = new PdfPCell(new Phrase(jourFormation.getJour()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mytable.addCell(cell);

				cell = new PdfPCell(new Phrase(jourFormation.getIndiceJour()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mytable.addCell(cell);

				cell = new PdfPCell(new Phrase(jourFormation.getMatiere()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				// Ajout de la couleur
				Integer red = Integer.valueOf(jourFormation.getCouleur().substring(1, 3), 16);
				Integer green = Integer.valueOf(jourFormation.getCouleur().substring(3, 5), 16);
				Integer blue = Integer.valueOf(jourFormation.getCouleur().substring(5, 7), 16);
				cell.setBackgroundColor(new BaseColor(red, green, blue));
				mytable.addCell(cell);

				cell = new PdfPCell(new Phrase(jourFormation.getFormateur()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mytable.addCell(cell);

				cell = new PdfPCell(new Phrase(jourFormation.getTitre()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mytable.addCell(cell);
			}
			
			/////////////////////////////// fin du tableau//////////////////////

			// With PdfWriter, the document is written to the ByteArrayOutputStream.
			PdfWriter.getInstance(document, out);
			// The table is inserted into the PDF document.
			document.open();
			
			document.add(mytable);
			// In order for the data to be written to the ByteArrayOutputStream, the
			// document must be closed.
			document.close();

		} catch (

		DocumentException ex) {

			Logger.getLogger(GenSimpleReportVersionOK.class.getName()).log(Level.SEVERE, null, ex); // à revoire
		}
		// In the end, the data is returned as ByteArrayInputStream.
		return new ByteArrayInputStream(out.toByteArray());
	}
}
