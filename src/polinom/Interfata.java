package polinom;
import polinom.*;
import polinom.Polinom;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*; 

public class Interfata extends Frame implements ActionListener {
	int iesire=0;
	public JFrame frame;
	JPanel p = new JPanel(); 
	JPanel p1 = new JPanel(); 
	JPanel p2 = new JPanel(); 
	JPanel p3 = new JPanel(); 	   
	JPanel p4 = new JPanel(); 
	JLabel pol1 = new JLabel ("Polinom1 ");
	JLabel pol2 = new JLabel ("Polinom2 ");
	JLabel pol3 = new JLabel ("Polinom3 ");
	JTextField tf1 = new JTextField(25); 
	JTextField tf2 = new JTextField(25); 
	JTextField tf3 = new JTextField(25); 
	JButton adunare = new JButton("+ ");
	JButton scadere = new JButton("- "); 
	JButton inmultire = new JButton("* ");
	JButton derivare = new JButton("derivare polinom1 ");
	JButton integrare = new JButton("integrare polinom1 ");

   public Interfata() {
	   frame = new JFrame ("Polinom"); 
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(640, 400);   
	//panou1   	   
	   p1.add(pol1);
	   p1.add(tf1);
	//panou2   
	   p2.add(pol2);
	   p2.add(tf2);
	//panou3
	   p3.add(pol3);
	   p3.add(tf3);
	//panou4
	   p4.add(adunare);
	   p4.add(scadere);
	   p4.add(inmultire);
	   p4.add(derivare);
	   p4.add(integrare);
	   p.add(p1);
	   p.add(p2);
	   p.add(p3);
	   p.add(p4);
	   adunare.addActionListener(this);
	   scadere.addActionListener(this);
	   inmultire.addActionListener(this);
	   derivare.addActionListener(this);
	   integrare.addActionListener(this);
	   p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS)); 
	   frame.setContentPane(p); 
	   frame.setVisible(true); 
   }
   //convertesc din char in int
   public int convertesteNr(char result)
   {
	   int x;
	   x= Integer.valueOf(result);
	   x=x-48;
	   return x;
   }
   //conditiePol prelucreaza String-ul care este dat din textField si extrage din el coeficientii si puterile
   public Polinom conditiePol(String polinom)
   {
	   int lungime1=polinom.length();
	   List<Monom> y=new ArrayList<Monom>();
	   Polinom b=new Polinom(y);
	   int ok=1,verificareSemn=1,coef=0,putere=0,k1=0,k2=0;
	   int coef1[] = new int[50];
	   for(int i=0;i<coef1.length;i++)	coef1[i] = 0;
	   int putere1[] = new int[50];
	   for(int i=0;i<putere1.length;i++)	putere1[i] = 0;
	   for (int i=0;i<lungime1;i++)
	   {
		   char result = polinom.charAt(i);
		   if(result=='-' )
		   {verificareSemn=0;
			putere1[k2++]=putere;
			ok=1;putere=0;
		   }
		   else if((result=='0' || result=='1'|| result=='2'||result=='3' || result=='4'|| result=='5'||result=='6' || result=='7'|| result=='8'|| result=='9') && ok==1)
				   { coef=coef*10+convertesteNr(result);}
		   else if(result=='x'){
			   if(verificareSemn==0)
			   {coef=-coef;}
			   verificareSemn=1;
			   coef1[k1++]=coef;
			   ok=0;coef=0;  }
		   else if((result=='0' || result=='1'|| result=='2'||result=='3' || result=='4'|| result=='5'||result=='6' || result=='7'|| result=='8'|| result=='9') && ok==0)
		   { putere=putere*10+convertesteNr(result);
			   if(i==lungime1-1)
			   {putere1[k2++]=putere;
				   ok=1;  putere=0;}
		   }
		   else if(result=='+')
		   {putere1[k2++]=putere;
			   ok=1;putere=0;		  
		   }
		   else if(result=='^')
		   {   }
		   else
		   {iesire=1;}
	   }
	   for(int i=0;i<coef1.length;i++)
	   {
		   if(coef1[i]!=0)
		   {
			   Monom f6=new Monom(coef1[i],putere1[i]);
			   b.add(f6);
		   }
	   }
	   return b;
   }
   @Override
   public void actionPerformed(ActionEvent evt) {
	   String polinom1=tf1.getText();
	   String polinom2=tf2.getText();
	   Polinom pol1 = conditiePol(polinom1);
	   Polinom pol2 = conditiePol(polinom2);
	   // aici am verificat daca sursa butonului este unul dintre cele 5 butoane
	   if(evt.getSource()==adunare){
		   if(iesire==1)
		   {tf3.setText("Ai gresit polinomul");
			   iesire=0;}
		   else
		   {Polinom u=pol1.addPolinom(pol1,pol2);
		   tf3.setText(u.toString());}
	   }
	   if(evt.getSource()==scadere){
		   if(iesire==1)
		   {tf3.setText("Ai gresit polinomul");
			   iesire=0;}
		   else
		   {Polinom u=pol1.scaderePolinom(pol1,pol2);
		   tf3.setText(u.toString());}
	   }
	   if(evt.getSource()==inmultire){
		   if(iesire==1)
		   {tf3.setText("Ai gresit polinomul");
			iesire=0;}
		   else
		   {Polinom u=pol1.inmultirePolinom(pol1,pol2);
		   tf3.setText(u.toString());}
	   }
	   if(evt.getSource()==derivare) {
		   if(iesire==1)
		   {tf3.setText("Ai gresit polinomul");
			   iesire=0;}
		   else
		   {Polinom u=pol1.derivarePolinom(pol1);
		   tf3.setText(u.toString());}
	   }
	   if(evt.getSource()==integrare) {
		   if(iesire==1)
		   {tf3.setText("Ai gresit polinomul");
			   iesire=0;}
		   else
		   {Polinom u=pol1.integrarePolinom(pol1);
		   tf3.setText(u.toString());}
	   }
   }
}
