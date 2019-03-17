package polinom;
public class Monom {
	public int coef;
	public int putere;
	boolean verificare;
	public Monom(int coef,int putere)
	{
		this.coef=coef;
		this.putere=putere;
	}
	public int getCoef()
	{
		return coef;
	}
	public int getPutere()
	{
		return putere;
	}
	public boolean getVerificare()
	{
		return verificare;
	}	
	public void setVerificare(boolean verificare)
	{
		this.verificare=verificare;
	}
	public void setCoef(int coef)
	{
		this.coef=coef;
	}
	public void setPutere(int putere)
	{
		this.putere=putere;
	}
	public String toString() {
        return this.coef +"x^" + this.putere;
        
    }
}
