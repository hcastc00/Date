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


	public int getDay(){
		return this.day;
	}

	public int getMonth(){
		return this.month;
	}

	public int getYear(){
		return this.year;
	}

	

	public void setDay(int day){
		this.day = day;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	
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


	public boolean isSameYearIf(Date date){
		if (this.getYear() == getYear()) {
			return true;
		}
		else{
			return false;
		}
	}	
	
	public boolean isSameMonthIf(Date date){
		if (this.getMonth() == getMonth()) {
			return  true;
		}
		else{
			return false;
		}
	}	

	public boolean isSameDayIf(Date date){
		if (this.getDay() == getDay()) {
			return  true;
		}
		else{
			return false;
		}
	}	

	public boolean isSameIf(Date date){
		if (isSameDay(date) && isSameMonth(date) && isSameYear(date)){
			return  true;
		}
		else{
			return false;
		}
	}	

	
	public boolean isSameYear(Date date){
		return this.getYear() == getYear();
	}	

	public boolean isSameMonth(Date date){
		return this.getMonth() == getMonth();
	}	

	public boolean isSameDay(Date date){
		return this.getDay() == getDay();
	}	

	public boolean isSame(Date date){
		return (isSameDay(date) && isSameMonth(date) && isSameYear(date));
	}	

	
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


	public String monthsToEndYear(){
		int monthsToEndYear = 12 - this.getMonth();
		StringBuffer salida = new StringBuffer("Hasta finalizar el año queda(n) "+monthsToEndYear+" mes(es)");
		return salida.toString();
	}


	public String dateToString(){
		return this.day +" de "+ this.printMonthName() +" de "+ this.year;
	}

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


	public int daysSinceYearBeginning(){
		int daysInMonth, daysSinceYearBeginning = 0;
		for (int i=1;i<this.month;i++ ) {
			switch(i){
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
			daysSinceYearBeginning = daysSinceYearBeginning + daysInMonth;
		}
		daysSinceYearBeginning = daysSinceYearBeginning + this.day;

		return daysSinceYearBeginning;
	}


	//esta mal, revisar
	public int attemptsToGuessDate(){
		int randomDay = 0, randomMonth = 0, intentos = 0;
		while(this.day!=randomDay && this.month!=randomMonth){
			randomDay = (int)(Math.random() * ((31 - 1) + 1)) + 1;
			randomMonth = (int)(Math.random() * ((12 - 1) + 1)) + 1;
			intentos++;
		}
		return intentos;
	}




}