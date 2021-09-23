package modules;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.util.Pair;


public class Programme {

	public static void main(String[] args) {
		
		//dateformat
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 
		 
		//creation de la liste des departements		
		List<Departement> Departements  = Arrays.asList(
		new Departement(1, "Ressources humaines"),
		new Departement(2, "Finance et comptabilit�"),
		new Departement(3, "Informatique"));
		
		//creation de la liste des employes
		List<Employe> employes = null;
		try {
			employes = Arrays.asList(
				new Employe(1,"Mohamedi","Mohammed",dateFormat.parse("08/05/1945"),'m',true,55555.00,1),
				new Employe(2,"Rih","Amina",dateFormat.parse("01/11/1954"),'f',true,44444.00,2),
				new Employe(3,"Loubar","Fares",dateFormat.parse("20/08/1955"),'m',false,33333.00,3),
				new Employe(4,"Kaidi","Rabie",dateFormat.parse("20/08/1956"),'f',true,55555.00,2),
				new Employe(5,"Boulehbel","Mohammed",dateFormat.parse("11/12/1961"),'m',true,66666.00,2),
				new Employe(6,"Ait Kaci","Amina",dateFormat.parse("18/03/1962"),'f',false,44444.00,1),
				new Employe(7,"Bouteldja","Zakaria",dateFormat.parse("05/07/1962"),'m',false,33333.00,3));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//la liste des employer
		System.out.println("<<<<< Les employees >>>>>\n");
		employes.stream().forEach(e->System.out.println(e.getNom()));
		
		
		System.out.println("\n\n******************************************\n");

		
		//la liste des employer moin de 60ans
		System.out.println("<<<<< Les employees ag�s moin de 60ans >>>>>\n");
		employes.stream().filter(e-> e.getAge()<60).forEach(e->System.out.println(e.getNom()+" age : "+e.getAge()));
		
		
		
		System.out.println("\n\n******************************************\n");
		
		
		
		//la liste des employer hommes mari�s
		System.out.println("<<<<< Les employees hommes mari�s >>>>>\n");
		employes.stream().filter(e-> e.getSexe()=='m'&& e.isMarie()).forEach(e->System.out.println(e.getNom()+" , mari� : "+e.isMarie()+" , "+e.getSexe()+" ."));
		
		
		
		System.out.println("\n\n******************************************\n");
		
		
		
		//la liste des employer tri�e alphab�tiquement
				System.out.println("<<<<< Les employees tri�e alphab�tiquement >>>>>\n");
				List <Employe> sortedListAlph = 
						employes.stream()
						.sorted(Comparator.comparing(Employe::getNom))
						.collect(Collectors.toList());
				sortedListAlph.forEach(e->System.out.println(e.getNom()));		
		
				
	    System.out.println("\n\n******************************************\n");
	    
	    
	    
		//la liste des employer tri�e par age puis s'ils ont le meme age , par salaire decroissant
				System.out.println("<<<<< Les employees tri�e par age puis s'ils ont le meme age , par salaire decroissant >>>>>\n");
				List <Employe> sortedListAS = 
						employes.stream()
						.sorted(Comparator
								.comparingInt(Employe::getAge).reversed()
								.thenComparingDouble(Employe::getSalaire).reversed())
						.collect(Collectors.toList());
				sortedListAS.forEach(e->System.out.println(e.getNom()+" => age : "+e.getAge()+" => Salaire : "+e.getSalaire()));	
				
				

        System.out.println("\n\n******************************************\n");
        
        
		//R�cuperer une liste de 2 employe�es � partir du 3eme
                System.out.println("<<<<< liste de 2 employe�es � partir du 3eme >>>>>\n");
                List <Employe> skipLimit =
                		employes.stream()
                		.skip(3)
                		.limit(2)
                		.collect(Collectors.toList());
                skipLimit.forEach(e->System.out.println(e.getNom()));


        System.out.println("\n\n******************************************\n");
        
        

      //la liste des employees sans r�p�tition des pr�noms des employ�es
		System.out.println("<<<<< Les Prenoms des employees sans r�p�tition >>>>>\n");
		List<String> PrenomSansRep = 
				employes.stream()
				.map(Employe::getPrenom)
				.distinct()
				.collect(Collectors.toList());
		
		PrenomSansRep.forEach(e->System.out.println(e));
		
		
		
        System.out.println("\n\n******************************************\n");
        
        

		 //Grouper les employees par Id de departement
		System.out.println("<<<<< Les employ�es Group�s par Id de d�partement >>>>>\n");
		Map<Integer, List<Employe>> groupeByIdDepartement =
				employes.stream()
				.collect(Collectors.groupingBy(e->e.getIdDepartement()));
		
		for(Integer id_dep : groupeByIdDepartement.keySet()) {
			System.out.println("---------- DEPARTEMENT " + id_dep+" ----------");
			groupeByIdDepartement.get(id_dep).forEach(e-> System.out.println( e.getNom()));
		}
		
		
        System.out.println("\n\n******************************************\n");
        
        
        
        //D�viser les employees par mari� ou non
		System.out.println("<<<<< Les employ�es mari� et c�libatire >>>>>\n");
        
		Map<Boolean, List<Employe>> groupeMarieCelib =
				employes.stream().collect(Collectors.
						partitioningBy(e->e.isMarie()));
		System.out.println("---------- Les employ�es Celibataires ----------");
		groupeMarieCelib.get(false).forEach(e-> System.out.println(e.getNom()));
		System.out.println("---------- Les employ�es Mari�s ----------");
		groupeMarieCelib.get(true).forEach(e-> System.out.println(e.getNom()));
		
		
		 System.out.println("\n\n******************************************\n");
		
		  //Jointure entre les employes et les departements
		System.out.println("<<<<< Jointure entre les employes et les departements >>>>>\n");
		
		List<Pair<Employe,Departement>> join = 
				employes.stream()
				.flatMap(e-> Departements.stream()
				.filter(dep-> dep.getId() == e.getIdDepartement())
				.map(dep-> new Pair<Employe,Departement>(e,dep)))
				.collect(Collectors.toList());
		join.forEach(e-> System.out.println(e.getKey().getNom()+ " => Departement : " + e.getValue().getLibelle()));
		
		
		 System.out.println("\n\n******************************************\n");
		 
		 
		 //Afficher le salaire min , max et moyen
			System.out.println("<<<<< Affichage du salaire min , max et moyen >>>>>\n");
			
			DoubleSummaryStatistics MinMaxMoy = 
					employes.stream()
					        .collect(Collectors.summarizingDouble(e->e.getSalaire()));
			System.out.println("Salaire min : "+MinMaxMoy.getMin()+" DA");
			System.out.println("Salaire max : "+MinMaxMoy.getMax()+" DA");
			System.out.println("Salaire moyen : "+MinMaxMoy.getAverage()+" DA");
	}

}
