package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(12, 04, 2017);
			System.out.println(today.toString());
			System.out.println(today.printMonthName());
			System.out.println(today.printSeasonOfMonth());
			System.out.println(today.monthsToEndYear());
			System.out.println(today.dateToString());
			System.out.println(today.printDatesToEndMonth());
			System.out.println(today.printMonthsWhithSameDays());
			System.out.println("Desde el inicio del año han pasado "+today.daysSinceYearBeginning());
			System.out.println("Se han realizado "+today.attemptsToGuessDate()+" intentos para acertar la fecha.");
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}


	}

}