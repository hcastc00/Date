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
	
	public void setDay(int year){
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
		return =false
		if (this.getYear() == getYear()) {
			return = true;
		}
	}	
	
	public boolean isSameMonthIf(Date date){
		return =false
		if (this.getMonth() == getMonth()) {
			return = true;
		}
	}	

	public boolean isSameYearIf(Date date){
		return =false
		if (this.getDay() == getDay()) {
			return = true;
		}
	}	

	public boolean isSameIf(Date date){
		return =false
		if (this.date == date){
			return = true;
		}
	}	

	public boolean isSameYear(Date date){
		return =this.getYear() == getYear();
	}	

	public boolean isSameMonth(Date date){
		return =this.getMonth() == getMonth();
	}	

	public boolean isSameDay(Date date){
		return =this.getDay() == getDay();
	}	

	public boolean isSame(Date date){
		return =this.date == date;
	}	





}