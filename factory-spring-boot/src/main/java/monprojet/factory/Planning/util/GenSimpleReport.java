package monprojet.factory.Planning.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import monprojet.factory.entity.Planning;

public class GenSimpleReport {

	public static ByteArrayInputStream simpleReport(List<Planning> modules) {

		Document document = new Document();
		// GenSimpleReport creates PDF file from the provided data.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String dateDebut = "18-01-2018";
		String dateFin = "28-01-2018";

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
//			System.out.println("matiere = " + modules.get(j).getNom());
			int duree = modules.get(j).getDuree();
			weekend = false;

//			System.out.println("duree = " + duree);

			for (int i = 1; i <= duree; i++) {

//				System.out.println("jour = " + listeJourFormation.get(indice).getJour());
				if (listeJourFormation.get(indice).getJour().equals("sam")
						|| listeJourFormation.get(indice).getJour().equals("dim")) {
					duree = 2;
//					System.out.println("c'est un weekend");
					weekend = true;

				} else {

//					System.out.println("ce n'est pas un weekend " + listeJourFormation.get(indice).getJour());
					listeJourFormation.get(indice).setMatiere(modules.get(j).getNom());
					listeJourFormation.get(indice).setFormateur(modules.get(j).getFormateur());
					listeJourFormation.get(indice).setTitre(modules.get(j).getTitreFormateur());
					listeJourFormation.get(indice).setCouleur(modules.get(j).getCouleur());
				}
				indice++;
			}
		}
		for (jourFormation jourFormation : listeJourFormation) {
			System.out.println("******* : "+jourFormation.toString());
		}

		try {
			// a table with 6 columns
			PdfPTable mytable = new PdfPTable(6);
			mytable.setWidthPercentage(90);
			mytable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			mytable.setTotalWidth(new float[] { 4, 3, 2, 10, 5, 4 });// tailles des cellules

			/****************************************
			 ********* l'entête du tableau **********
			 ***************************************/

			// the cell object
			PdfPCell cell;

			cell = new PdfPCell(new Phrase("Mois"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			mytable.addCell(cell);
			mytable.setHeaderRows(1); // -------------------------------------------setHeaderRows

			// we add a cell with colspan 2
			cell = new PdfPCell(new Phrase("Date"));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(2);
			mytable.addCell(cell);

			mytable.addCell(new PdfPCell(new Phrase("Planning")));
			mytable.addCell(new PdfPCell(new Phrase("Formateurs")));
			mytable.addCell(new PdfPCell(new Phrase("Titres")));
			/****************************************
			 ********* les lignes **********
			 ***************************************/
			// 1re ligne
			// now we add a cell with rowspan n1= 2

			String mois1 = "";
			String mois2 = "";
			int i = 0;
			int cpt = 0;
			int indTab = 0;

			while (i < listeJourFormation.size()) {
				System.out.println("je place un mois");

				mois1 = listeJourFormation.get(i).getMois();
				mois2 = listeJourFormation.get(i + 1).getMois();
				while (mois1.equals(mois2) && i < listeJourFormation.size()) {
					cpt++;
					i++;
					// System.out.println(cpt);
					if (i + 1 < listeJourFormation.size()) {
						mois1 = listeJourFormation.get(i).getMois();
						mois2 = listeJourFormation.get(i + 1).getMois();
					}
				}
				// System.out.println("cpt = " + cpt);
				cell = new PdfPCell(new Phrase(mois1));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setRowspan(cpt + 1);
				cell.setRotation(90);
				mytable.addCell(cell);
				int count = 0;
				int nbLiMat = 0;
				int nbLiMatS = 0;
				boolean mise = false;
				for (int j = 0; j <= cpt; j++) {
					System.out.println("je place les matieres");
					String matiere1 = "";
					String matiere2 = "";

					if (j + indTab + count + 1 < listeJourFormation.size()) {
						matiere1 = listeJourFormation.get(j + indTab + count).getMatiere();
						matiere2 = listeJourFormation.get(j + indTab + count + 1).getMatiere();
						System.out.println("matiere1 = " + matiere1);
						System.out.println("matiere2 = " + matiere2);
					}

					while (matiere1.equals(matiere2) && j + indTab + count < listeJourFormation.size()) {
						count++;
						if (j + indTab + count + 1 < listeJourFormation.size()) {
							matiere1 = listeJourFormation.get(j + indTab + count).getMatiere();
							matiere2 = listeJourFormation.get(j + indTab + count + 1).getMatiere();
						}
						System.out.println("count = " + count);
						System.out.println("matiere1 = " + matiere1);
						System.out.println("matiere2 = " + matiere2);
					}
					// System.out.println("count = " + count);
					nbLiMat = count;

					count = 0;

					int x = nbLiMat + 1;
					System.out.println("la matiere est sur " + x + " ligne");
					if (!mise) {
						System.out.println("la matiere n'est pas encore mise dans le tableau donc on la place");
						cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getJour()));
						mytable.addCell(cell);
						cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getIndiceJour()));
						mytable.addCell(cell);

						cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getMatiere()));

						//////////////////////////////////////////////////////////////////////// couleur

						Integer red = Integer.valueOf((listeJourFormation.get(j + indTab).getCouleur()).substring(1, 3),
								16);
						Integer green = Integer
								.valueOf((listeJourFormation.get(j + indTab).getCouleur()).substring(3, 5), 16);
						Integer blue = Integer
								.valueOf((listeJourFormation.get(j + indTab).getCouleur()).substring(5, 7), 16);
						cell.setBackgroundColor(new BaseColor(red, green, blue));
						//////////////////////////////////////////////////////////////////////// couleur
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell.setRowspan(nbLiMat + 1);
						nbLiMatS = nbLiMat;
						mytable.addCell(cell);

						cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getFormateur()));
						mytable.addCell(cell);
						cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getTitre()));
						mytable.addCell(cell);
						mise = true;
						System.out.println("mise = " + mise);
					} else {
						System.out.println("la matiere existe déja il faut la sauter");
						for (int k = 0; k < nbLiMatS; k++) {
							cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getJour()));
							mytable.addCell(cell);
							cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getIndiceJour()));
							mytable.addCell(cell);
							cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getFormateur()));
							mytable.addCell(cell);
							cell = new PdfPCell(new Phrase(listeJourFormation.get(j + indTab).getTitre()));
							mytable.addCell(cell);
							mise = false;
						}
						// }
						nbLiMat = 0;
					}
				}
				indTab = cpt;
				cpt = 0;
				i++;
			}

			// -------------------------------------------------------------------------------------fin
			// du tableau

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

			Logger.getLogger(GenSimpleReport.class.getName()).log(Level.SEVERE, null, ex); // à revoire
		}
		// In the end, the data is returned as ByteArrayInputStream.
		return new ByteArrayInputStream(out.toByteArray());
	}
}
