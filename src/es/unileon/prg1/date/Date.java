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
		// Comprueba si el dia especificado pertenece al mes y si no lanza una excepcion.
		if (isDayOfMonthRight(day,month)==false) {
			throw new DateException("Día " + day + " no valido" +
					" Valores posibles entre 1 y 31 en función del mes");
		}
		
		else{
			this.day = day;
		}
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

//GET
	
	//Devuelve el valor del dia de una fecha dada
	public int getDay(){
		return this.day;
	}

	//Devuelve el valor del mes de una fecha dada
	public int getMonth(){
		return this.month;
	}

	//Devuelve el valor del anio de una fecha dada
	public int getYear(){
		return this.year;
	}

	
//SET	
	
	// Guarda como dia un valor dado
	public void setDay(int day){
		this.day = day;
	}
	
	//Guarda como mes un valor dado
	public void setMonth(int month){
		this.month = month;
	}
	
	//Guarda como anio un valor dado
	public void setYear(int year){
		this.year = year;
	}
	

	
	private boolean isDayOfMonthRight(int day,int month){
		boolean salida = true;
		switch(month){
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12:
				if (day<1 || day>31) {
					salida = false;
				}

				break;

			case 2:
				if (day<1 || day>28) {
					salida = false;
				}
				
				break;
			
			default:
				if (day<1 || day>30) {
					salida = false;
				}
		}
	
		return salida;
	}	

	//Devuelve un valor true si coinciden los anios de las fechas dadas
	public boolean isSameYearIf(Date date){
		if (this.getYear() == getYear()) {
			return true;
		}
		else{
			return false;
		}
	}	
	
	//Devuelve un valor true si coinciden los meses de las fechas dadas
	public boolean isSameMonthIf(Date date){
		if (this.getMonth() == getMonth()) {
			return  true;
		}
		else{
			return false;
		}
	}	

	//Devuelve un valor true si coinciden los dias de las fechas dadas
	public boolean isSameDayIf(Date date){
		if (this.getDay() == getDay()) {
			return  true;
		}
		else{
			return false;
		}
	}	

	//Devuelve un valor true si coinciden las fechas dadas
	public boolean isSameIf(Date date){
		if (isSameDay(date) && isSameMonth(date) && isSameYear(date)){
			return  true;
		}
		else{
			return false;
		}
	}	

	
	//Devuelve un valor true si coinciden los anios de las fechas dadas
	public boolean isSameYear(Date date){
		return this.getYear() == getYear();
	}	

	//Devuelve un valor true si coinciden los meses de las fechas dadas
	public boolean isSameMonth(Date date){
		return this.getMonth() == getMonth();
	}	

	//Devuelve un valor true si coinciden los dias de las fechas dadas
	public boolean isSameDay(Date date){
		return this.getDay() == getDay();
	}	

	//Devuelve un valor true si coinciden las fechas dadas
	public boolean isSame(Date date){
		return (isSameDay(date) && isSameMonth(date) && isSameYear(date));
	}	

	// Devuelve el nombre del mes de la fecha dada
	public String printMonthName(){
		StringBuffer salida = new StringBuffer();
		switch(this.month){
			case 1:
				salida.append("Enero");
				break;
		
			case 2:
				salida.append("Febrero");
				break;
			
			case 3:
				salida.append("Marzo");
				break;
				
			case 4:
				salida.append("Abril");
				break;
		
			case 5:
				salida.append("Mayo");
				break;
			
			case 6:
				salida.append("Junio");
				break;
				
			case 7:
				salida.append("Julio");
				break;
		
			case 8:
				salida.append("Agosto");
				break;
			
			case 9:
				salida.append("Septiembre");
				break;
				
			case 10:
				salida.append("Octubre");
				break;
		
			case 11:
				salida.append("Noviembre");
				break;
			
			case 12:
				salida.append("Diciembre");
				break;
		}
	return salida.toString();
	}

	// Devuelve en la estacion predominante del mes de la fecha dada
	public String printSeasonOfMonth(){
		StringBuffer salida = new StringBuffer("La estacion predominante de este mes es ");
		
		switch(this.getMonth()){
			case 1: //next
			case 2: //next
			case 3:
				salida.append("Invierno");
				break;
			
			case 4: //next
			case 5: //next
			case 6:
				salida.append("Primavera");
				break;
				
			case 7: //next
			case 8: //next
			case 9:
				salida.append("Verano");
				break;
				
			case 10: //next
			case 11: //next
			case 12:
				salida.append("Otoño");
				break;
		}
	return salida.toString();
	}

	// Devuelve el num de meses que faltan para acabar el anio.
	public int monthsToEndYear(){
		int monthsToEndYear = 12 - this.getMonth();
		return monthsToEndYear;
	}

	// Devuelve la fecha dada en forma de String con el formato XX del MES del XXXX. Ej: 2 de Abril del 2019
	public String dateToString(){
		return this.day +" de "+ this.printMonthName() +" de "+ this.year;
	}

	//Devuelve en forma de String todas las fechas hasta terminar el mes a partir de una fecha dada.
	public String printDatesToEndMonth(){
		StringBuffer salida = new StringBuffer("Hasta finalizar el mes pasarán los días ");
		int daysInMonth;
		switch(month){
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12:
				daysInMonth = 31;
				break;
			
			case 2:
				daysInMonth = 28;
				break;
			
			default:
				daysInMonth = 30;
		}
		
		for (int i = 0;i<=daysInMonth-this.day;i++ ) {
			salida.append((this.day+i)+"/"+this.month+"/"+this.year+", ");
		}
		return salida.toString();
	}

	// Devuelve una lista de los meses que tienen la misma cantidad de dias que el de la fecha dada.
	public String printMonthsWhithSameDays(){
		StringBuffer salida = new StringBuffer(this.printMonthName()+" tiene el mismo número de días que ");

		switch(this.getMonth()){
				case 1:
					salida.append("Marzo, Mayo, Julio, Agosto, Octubre y Diciembre");
					break;
			
				case 2:
					salida.append("ningún otro més");
					break;
				
				case 3:
					salida.append("Enero, Mayo, Julio, Agosto, Octubre y Diciembre");
					break;
					
				case 4:
					salida.append("Junio, Septiembre y Noviembre");
					break;
			
				case 5:
					salida.append("Enero, Marzo, Julio, Agosto, Octubre y Diciembre");
					break;
				
				case 6:
					salida.append("Abril, Septiembre y Noviembre");
					break;
					
				case 7:
					salida.append("Enero, Marzo, Mayo, Agosto, Octubre y Diciembre");
					break;
			
				case 8:
					salida.append("Enero, Marzo, Mayo, Junio, Octubre y Diciembre");
					break;
				
				case 9:
					salida.append("Abril, Junio y Noviembre");
					break;
					
				case 10:
					salida.append("Enero, Marzo, Mayo, Junio, Agosto y Diciembre");
					break;
			
				case 11:
					salida.append("Abril, Junio y Septiembre");
					break;
				
				case 12:
					salida.append("Enero, Marzo, Mayo, Junio, Agosto y Octubre");
					break;
		}
		return salida.toString();
	}

	// Devuelve los días que han pasado desde el 1 de Enero (incluyendo el dia dado)
	public int daysSinceYearBeginning(){
		int daysInMonth, daysSinceYearBeginning = 0;
		for (int i=1;i<this.month;i++ ) {
			switch(i){
				case 1: //next
				case 3: //next
				case 5: //next
				case 7: //next
				case 8: //next
				case 10:
					daysInMonth = 31;
					break;
				
				case 2:
					daysInMonth = 28;
					break;
				
				default:
					daysInMonth = 30;
			}
			daysSinceYearBeginning = daysSinceYearBeginning + daysInMonth;
		}
		daysSinceYearBeginning = daysSinceYearBeginning + this.day;

		return daysSinceYearBeginning;
	}

	// Cuenta los intentos reaizados para generar una fecha igual a la dada (dia/mes)
	public int attemptsToGuessDate(){
		int randomDay = 0, intentos = 0;
		while(this.daysSinceYearBeginning()!=randomDay){
			randomDay = (int)(Math.random() * ((365 - 1) + 1)) + 1;
			intentos++;
		}
		return intentos;
	}

	// Cuenta los intentos reaizados para generar una fecha igual a la dada (dia/mes) (CON DO-WHILE)
	public int attemptsToGuessDateDoWhile(){
		int randomDay = 0, intentos = 0;
		do{
			randomDay = (int)(Math.random() * ((365 - 1) + 1)) + 1;
			intentos++;
		}
		while(this.daysSinceYearBeginning()!=randomDay);
		return intentos;
	}

	/*
	* Devuelve el nombre del dia de la semana de una fecha dada.
	* 
	* @param firstDayOfTheYear
	* 	Valor en forma de int del dia de la semana en el que empezo el anio
		de la forma 0=lunes, 1=martes...
	*/
	public String dayOfTheWeek(int firstDayOfTheYear){
		int dayOfTheWeek = (this.daysSinceYearBeginning()%7)+firstDayOfTheYear; 
		StringBuffer salida = new StringBuffer("El "+this.dateToString()+" es ");
		switch (dayOfTheWeek){
			case 1:
				salida.append("Lunes");
				break;
			case 2:
				salida.append("Martes");
				break;
			case 3:
				salida.append("Miércoles");
				break;
			case 4:
				salida.append("Jueves");
				break;
			case 5:
				salida.append("Viernes");
				break;
			case 6:
				salida.append("Sábado");
				break;
			case 7:
				salida.append("Domingo");
				break;																																			
		}

		return salida.toString();
	}
}