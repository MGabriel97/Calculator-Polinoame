package polinom;
import java.util.*;
import java.util.ArrayList;
public class Polinom {
	List<Monom> pol1 = new ArrayList<Monom>();
	public Polinom(List<Monom> pol1)
	{
		this.pol1=pol1;
	}
	public void add(Monom newItem)   
	  {  
		pol1.add(newItem);

	  }
	public List<Monom> getPolinom( )
	{
		return pol1;
	}
	// Metoda adunareMembriPolinom aduna coeficientii la un polinom daca au aceeasi putere
	public void adunareMembriPolinom()
	{
		List<Monom> pol3 = new ArrayList<Monom>();
		pol3=pol1;
		for(int i=0;i<pol3.size();i++)
		{
			for(int j=i+1;j<pol3.size();j++)
			{
				if(pol3.get(i).putere==pol3.get(j).putere)
				{
					pol3.get(j).coef=pol3.get(i).coef+pol3.get(j).coef;
					i++;
				}
			}
		}
		for(int k=0;k<pol3.size();k++)
			for(int i=0;i<pol3.size();i++)
			{
				for(int j=i+1;j<pol3.size();j++)
				{
					if(pol3.get(i).putere==pol3.get(j).putere)
					{
						pol3.remove(i);
					}
				}		
			}
		
	}
	//la scaderea polinomilor am verificat daca au acceasi putere si daca au am adunat coeficientii
		// daca nu au putere egala i-am adaugat in polinomul final
	public Polinom addPolinom(Polinom pol1,Polinom pol2)
	{
		List<Monom> y=new ArrayList<Monom>();
		Polinom pol3=new Polinom(y);;
		pol1.adunareMembriPolinom();
		pol2.adunareMembriPolinom();
		Monom intermediar;
		for(Monom m1 : pol1.getPolinom())
		{
			for(Monom m2 : pol2.getPolinom())
			{
				if(m1.getPutere()==m2.getPutere())
				{
					intermediar=new Monom(m1.getCoef()+m2.getCoef(),m1.getPutere());
					pol3.add(intermediar);
					m1.setVerificare(true);
					m2.setVerificare(true);
				}
			}
		}
		for(Monom m1 : pol1.getPolinom())
		{
			if(m1.getVerificare()==false)
			{
				pol3.add(m1);
			}
		}
		for(Monom m2 : pol2.getPolinom())
		{
			if(m2.getVerificare()==false)
			{
				pol3.add(m2);
			}
		}
		return pol3;	
	}
	//la scaderea polinomilor am verificat daca au acceasi putere si daca au am scazut coeficientii
	// daca nu au putere egala i-am adaugat in polinomul final
	public Polinom scaderePolinom(Polinom pol1,Polinom pol2)
	{
		List<Monom> y=new ArrayList<Monom>();
		Polinom pol3=new Polinom(y);;
		pol1.adunareMembriPolinom();
		pol2.adunareMembriPolinom();
		Monom intermediar;
		for(Monom m1 : pol1.getPolinom())//parcurg monomi din primul polinom
		{
			for(Monom m2 : pol2.getPolinom())//parcurg monomi din al doilea polinom
			{
				if(m1.getPutere()==m2.getPutere())
				{
					intermediar=new Monom(m1.getCoef()-m2.getCoef(),m1.getPutere());
					pol3.add(intermediar);
					m1.setVerificare(true);
					m2.setVerificare(true);
				}
			}
		}
		for(Monom m1 : pol1.getPolinom())
		{
			if(m1.getVerificare()==false)
			{
				pol3.add(m1);
			}
		}
		for(Monom m2 : pol2.getPolinom())
		{
			if(m2.getVerificare()==false)
			{
				int x=m2.getCoef();
				m2.setCoef(-x);
				pol3.add(m2);
			}
		}
		return pol3;
	}
	// am inmultit intr-un nou monom coeficientii si puterile din monomi din cele doua polinaome pe rand
	public Polinom inmultirePolinom(Polinom pol1,Polinom pol2)
	{
		List<Monom> y=new ArrayList<Monom>();
		Polinom pol3=new Polinom(y);;
		pol1.adunareMembriPolinom();
		pol2.adunareMembriPolinom();
		Monom intermediar;
		for(Monom m1 : pol1.getPolinom()){//parcurg monomi din primul polinom
			for(Monom m2 : pol2.getPolinom()){//parcurg monomi din al doilea polinom
					intermediar=new Monom(m1.getCoef()*m2.getCoef(),m1.getPutere()*m2.getPutere());
					pol3.add(intermediar);
					m1.setVerificare(true);
					m2.setVerificare(true);
			}
		}
		pol3.adunareMembriPolinom();
		return pol3;
	}
	//la derivarea polinomului am parcurs monomi din polinom si am scris la un nou monom intermediar
		//ca coef este egal cu coef din monomul din polinom inmultit puterea din monom
	public Polinom derivarePolinom(Polinom pol1)
	{
		List<Monom> y=new ArrayList<Monom>();
		Polinom pol3=new Polinom(y);;
		pol1.adunareMembriPolinom();
		Monom intermediar;
		for(Monom m1 : pol1.getPolinom()){//parcurg monomi din primul polinom
			{
					intermediar=new Monom(m1.getCoef()*m1.getPutere(),m1.getPutere()-1);
					pol3.add(intermediar);
			}
		}
		pol3.adunareMembriPolinom();
		return pol3;
	}
	//la integrarea polinomului am parcurs monomi din polinom si am scris la un nou monom intermediar
	//ca coef este egal cu coef din monomul din polinom supra puterea din monom
	public Polinom integrarePolinom(Polinom pol1)
	{
		List<Monom> y=new ArrayList<Monom>();
		Polinom pol3=new Polinom(y);;
		pol1.adunareMembriPolinom();
		Monom intermediar;
		for(Monom m1 : pol1.getPolinom()){//parcurg monomi din primul polinom
			{
					intermediar=new Monom((m1.getCoef()/m1.getPutere()),m1.getPutere()-1);
					pol3.add(intermediar);
			}
		}
		pol3.adunareMembriPolinom();
		return pol3;
	}
	//functia toStrint este pentru tiparirea polinomului
	public String toString() {
	    String results = "";
	    //aici verific daca coeficientul unui monom este pozitiv sau negativ pentru a determina
	    //modul de afisare al acestuia
	    for(int i=0;i<pol1.size()-1;i++){
			if(pol1.get(i).coef>0 && pol1.get(i+1).coef>0){
			System.out.print(pol1.get(i).coef+"x^");
			System.out.print(pol1.get(i).putere+"+");
			}
			else{
				if(pol1.get(i).coef>0 && pol1.get(i+1).coef<0){
					System.out.print(pol1.get(i).coef+"x^");
					System.out.print(pol1.get(i).putere);
				}
			}
			if(pol1.get(i).coef<0 && pol1.get(i+1).coef>0){
					System.out.print(pol1.get(i).coef+"x^");
					System.out.print(pol1.get(i).putere+"+");
				}
			if(pol1.get(i).coef<0 && pol1.get(i+1).coef<0){
				System.out.print(pol1.get(i).coef+"x^");
				System.out.print(pol1.get(i).putere);
			}		
		}
		int i=pol1.size()-1;{
				if(pol1.get(i).coef>0){
					System.out.print(pol1.get(i).coef+"x^");
					System.out.print(pol1.get(i).putere);
				}
				if(pol1.get(i).coef<0){
					System.out.print(pol1.get(i).coef+"x^");
					System.out.print(pol1.get(i).putere);
				}
		}
		System.out.println();
	    for(Monom d : pol1) {
	    	System.out.println(d.coef+"ad"+d.putere);
	        results += d.toString(); //if you implement toString() for Dog then it will be added here
	        results +=" +";
	    }
	    return results;
	  }
}
