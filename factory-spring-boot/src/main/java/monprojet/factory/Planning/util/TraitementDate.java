package monprojet.factory.Planning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TraitementDate {

	public List<DateFormatee> formaterDate(String dateDebut, String dateFin) throws ParseException {

		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		Date date1;
		Date date2;
		List<DateFormatee> lesJours = new ArrayList<DateFormatee>();
		date1 = (Date) sdf.parse(dateDebut);
		date2 = (Date) sdf.parse(dateFin);
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);

		// calculle du nombre de jour de formation
		long jrs_formation = ((date2.getTime() - date1.getTime()) / 86400000) + 1;

		// Affichage des jours en format souhaitée

		DateFormatee dFormatee = new DateFormatee();

		for (int i = 1; i <= jrs_formation; i++) {

			int date_jour = c1.get(Calendar.DAY_OF_MONTH);
			String nom_jour = (c1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.FRANCE)).substring(0, 3);
			String nom_mois = (c1.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE));
			String nom_mois_Maj = nom_mois.substring(0, 1).toUpperCase() + nom_mois.substring(1);
			dFormatee = new DateFormatee(date_jour, nom_jour, nom_mois_Maj);
			lesJours.add(dFormatee);
			// System.out.println(lesJours.toString());

			c1.add(Calendar.DATE, 1);

		}
		return lesJours;

	}

}
