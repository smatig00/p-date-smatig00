package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(15, 9, 2017);
			System.out.println(today.toString());
			
			System.out.println(today.getYear());
			today.setYear(2019);
			System.out.println(today.getYear());
			System.out.println(today.getMonth());
			today.setMonth(3);
			System.out.println(today.getMonth());
			System.out.println(today.getDay());
			today.setDay(23);
			System.out.println(today.getDay());
			
			System.out.println(today.isSameYearWithIf(2019));
			System.out.println(today.isSameMonthWithIf(3));
			System.out.println(today.isSameDayWithIf(23));
			System.out.println(today.isSameWithIf(2019, 3, 23));
			
			System.out.println(today.isSameYearWithoutIf(2017));
			System.out.println(today.isSameMonthWithoutIf(9));
			System.out.println(today.isSameDayWithoutIf(15));
			System.out.println(today.isSameWithoutIf(2017, 9, 15));
			
			System.out.println(today.getMonthName());
			today.printMonthName();
			System.out.println(today.getDaysOfMonth(12));
			System.out.println(today.isDayRigth(35));
			System.out.println(today.getSeasonName());
			System.out.println(today.getMonthsLeft());
			System.out.println(today.dateToString(2019, 2, 27));
			System.out.println(today.getDaysLeftOfMonth());
			System.out.println(today.getMonthsSameDays());
			System.out.println(today.daysPast());
			System.out.println(today.numRandomTriesEqualDateWithWhile());
			System.out.println(today.numRandomTriesEqualDateWithDoWhile());
			System.out.println(today.nameOfTheDay(5));
			System.out.println(today.dayOfWeek(23));
			
			
			
			
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}

}
