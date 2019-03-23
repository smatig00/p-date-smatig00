package es.unileon.prg.date;

public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
		//TODO falta comprobar el dia
		this.day = day;
		if((day < 1) || (day > 31)){
			throw new DateException("Dia " + day + " no valido" + " Valores posibles entre 1 y 31\n");
		}
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	/*
	 *	Constructor vacio de la clase Date pasando como parametro un Date
	 */

	public Date(Date today){
		this.day = today.getDay();
		this.month = today.getMonth();
		this.year = today.getYear();
	}

	/*
	 *	Constructor de la clase Date predefinido
	 */

	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 2019;
	}

	/*
	 *	Metodos get y set de year, month y day
	 */

	public int getYear(){
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth(){
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay(){
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	/*
	 *	Metodos isSame CON IF
	 */

	public boolean isSameYearWithIf(int year){
		if(this.year == year){
			return true;
		}else{
			return false;
		}

	}

	public boolean isSameMonthWithIf(int month){
		if(this.month == month){
			return true;
		}else{
			return false;
		}

	}

	public boolean isSameDayWithIf(int day){
		if(this.day == day){
			return true;
		}else{
			return false;
		}

	}

	public boolean isSameWithIf(int year, int month, int day){
		if((this.year == year) && (this.month == month) && (this.day == day)){
			return true;
		}else{
			return false;
		}
	}

	/*
	 *	Metodos isSame sin IF
	 */

	public boolean isSameYearWithoutIf(int year){
		return this.year == year;
	}

	public boolean isSameMonthWithoutIf(int month){
		return this.month == month;
	}

	public boolean isSameDayWithoutIf(int day){
		return this.day == day; 
	}

	public boolean isSameWithoutIf(int year, int month, int day){
		return ((this.year == year) && (this.month == month) && (this.day == day));
	}

	/*
	 *	Metodo que devuelve el nombre del mes
	 */

	public String getMonthName(){
		String nombreMes = null;
		switch(this.month){
			case 1: 
				nombreMes = "Enero";
				break;
			case 2: 
				nombreMes = "Febrero";
				break;
			case 3: 
				nombreMes = "Marzo";
				break;
			case 4: 
				nombreMes = "Abril";
				break;
			case 5: 
				nombreMes = "Mayo";
				break;
			case 6: 
				nombreMes = "Junio";
				break;
			case 7: 
				nombreMes = "Julio";
				break;
			case 8: 
				nombreMes = "Agosto";
				break;
			case 9: 
				nombreMes = "Septiembre";
				break;
			case 10: 
				nombreMes = "Octubre";
				break;
			case 11: 
				nombreMes = "Noviembre";
				break;
			case 12: 
				nombreMes = "Diciembre";
				break;
			default:
				nombreMes = "No existe un mes que se corresponda con ese numero";
		}
		return nombreMes;
	}

	/*
	 *	Metodo que imprime el nombre del mes
	 */

	public void printMonthName(){
		System.out.println("El mes actual es: " + getMonthName());
	}

	/*
	 * Metodo que devuelve el numero de dias que tiene un mes
	 */

	public int getDaysOfMonth(int month){
		int days = 0;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 2:
				days = 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
			default:
				days = -1;
		}
		return days;
	}

	/*
	 *	Metodo que comprueba si el dia del mes es correcto
	 */

	public boolean isDayRigth(int day){
		if((day > 0) && (day <= getDaysOfMonth(this.month))){
			return true;
		}else{
			return false;
		}
	}

	/*
	 *	Metodo que devuelve la estacion del año
	 */

	public String getSeasonName(){
		String seasonName = null;
		switch(this.month){
			case 1:
			case 2:
				seasonName = "Invierno";
				break;
			case 3:
				if(day < 21){
					seasonName = "Invierno";
				}else{
					seasonName = "Primavera";
				}
				break;
			case 4:
			case 5:
				seasonName = "Primavera";
			case 6:
				if(day < 21){
					seasonName = "Primavera";
				}else{
					seasonName = "Verano";
				}
				break;
			case 7:
			case 8:
				seasonName = "Verano";
				break;
			case 9:
				if(day < 21){
					seasonName = "Verano";
				}else{
					seasonName = "Otoño";
				}
				break;
			case 10:
			case 11:
				seasonName = "Otoño";
				break;
			case 12:
				if(day < 21){
					seasonName = "Otoño";
				}else{
					seasonName = "Invierno";
				}
				break;
			default:
				seasonName = "No existe un mes que se corresponda con ese numero";
		}
		return seasonName;
	}

	/*
	 *	Metodo que dada una fecha devuelva los meses que queden hasta fin de año
	 */

	public String getMonthsLeft(){
		Date aux = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();

		for (int i = this.month + 1; i <= 12; i++){
			aux.setMonth(i);
			monthsLeft.append(aux.getMonthName() + "\n");
		}
		return monthsLeft.toString();
	}

	/*
	 *	Metodo que devuelve un String de la fecha
	 */

	public String dateToString(int year, int month, int day){
		String date = ("Fecha: " + day + "/" + month + "/" + year);
		return date;
	}

	/*
	 *	Metodo que dada una fecha devuelva todas las fechas hasta el fin del mes
	 */

	public String getDaysLeftOfMonth(){
		Date aux = new Date(this);
		StringBuffer daysLeft = new StringBuffer();
		
		for (int i = aux.getDay()+1; i <= getDaysOfMonth(month); i++) {
			aux.setDay(i);
			daysLeft.append(aux.toString() + "\n");
		}
		return daysLeft.toString();
	}

	/*
	 *	Metodo que dada una fecha devuelve los meses con el mismo numero de dias que el mes de la fecha dada
	 */

	public String getMonthsSameDays(){
		Date aux = new Date(this);
		StringBuffer months = new StringBuffer();

		for ( int i = 1; i <= 12; i++) {
			aux.setMonth(i);
			if (aux.getDaysOfMonth() == this.getDaysOfMonth()) {
				months.append(aux.getMonthName() + "\n");
			}
		}
		return months.toString();
	}
	
	/*
	 *	Metodo que devuelve el numero de dias del mes de una fecha dada 
	 */
	
	public int getDaysOfMonth() {
		return this.getDaysOfMonth(this.month);
	}

	/*
	 *	Metodo que dada una fecha cuenta el numero de dias que han pasado desde el primer dia del año (sin contar años bisisestos)
	 */

	public int daysPast() throws DateException{
		int count = 0;
		Date aux = new Date(1, 1, this.year);

		for(int i = 1; i < this.month; i++){
			count = count + getDaysOfMonth(i);
			aux.setMonth(i+1);
		}
		count = count + this.day -1;
		return count;
	}

	/*
	 *	Metodo que cuenta el numero de intentos necesarios para generar una fecha aleatoria que sea igual a una fecha dada (dentro del mismo año)
	 *	CON WHILE
	 */ 

	public int numRandomTriesEqualDateWithWhile(){
		int day = 0;
		int month = 0;
		int year = 0;
		int tries = 0;

		while(!this.isSameWithIf(year, month, day)){
			day = (int)(Math.random()*this.getDaysOfMonth(month))+1;
			month = (int)(Math.random()*12)+1;
			year = this.year;
			tries++;
		}
		return tries;
	}

	/*
	 *	Metodo que cuenta el numero de intentos necesarios para generar una fecha aleatoria que sea igual a una fecha dada (dentro del mismo año)
	 *	CON DO WHILE
	 */ 

	public int numRandomTriesEqualDateWithDoWhile(){
		int day = 0;
		int month = 0;
		int year = 0;
		int tries = 0;

		do{
			day = (int)(Math.random()*this.getDaysOfMonth(month))+1;
			month = (int)(Math.random()*12)+1;
			year = this.year;
			tries++;
		} while(!this.isSameWithIf(year, month, day));
		return tries;
	}
	
	/*
	 * Metodo que nombra los dias de la semana
	 */

	public String nameOfTheDay(int day){
		String name;
		switch(day){
			case 1:
				name = "Lunes";
				break;
			case 2:
				name = "Martes";
				break;
			case 3:
				name = "Miercoles";
				break;
			case 4:
				name = "Jueves";
				break;
			case 5:
				name = "Viernes";
				break;
			case 6: 
				name = "Sabado";
				break;
			case  7:
				name = "Domingo";
				break;
			default:
				name = "El valor introducido no se corresponde con ningun dia";
		}
		return name;
	}

	/*
	 *	Metodo que para una fecha dada y sabiendo el dia de la semana del primer dia del año de la fecha, devuelva el dia de la semana para la fecha dada
	 */

	public String dayOfWeek(int day) throws DateException{
		int name;
		name = (daysPast() % 7 + day) % 7;
		return nameOfTheDay(name);
	}

}