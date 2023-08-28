package Conto.Main.Test;

import Conto.Dao.DaoConti;
import Conto.Dao.DaoException;
import Conto.Dto.Conti;

import java.util.List;
import java.util.Scanner;

public class ContiMain {
    static Scanner sc = new Scanner(System.in);
    static DaoConti dc= new DaoConti();
    public static void main(String[] args) throws DaoException {
//        Conti c = new Conti("2", 4444, 33333, "HU", "As", "123");
//        Conti c = new Conti();
//        c.setABI(44444);
//        System.out.println(c.getABI());
        int choise=0;
        do{
            System.out.println("cosa vuoi fare?");
            System.out.println("1 inserisci un nuovo conto");
            System.out.println("2 cerca un conto per cognome o codice fiscale");
            System.out.println("3 visualizza tutti conti");
           choise=sc.nextInt();
           sc.nextLine();
           switch (choise){
               case 1: inserisciConto();
                   break;
               case 2: ricercaConto();
                   break;
               case 3: visualizzaConti();
               break;
           }
        }while(choise!=0);
    }
    public static void visualizzaConti() throws DaoException {
        List<Conti> c = dc.getAll();
        for(Conti con : c){
            System.out.println(con);
        }
    }

    private static void ricercaConto() throws DaoException {
        System.out.println("inserisci cognome o codice fiscale");
        String search = sc.nextLine();
        List<Conti> conti = dc.findByText(search);
        System.out.println(conti);
    }
    public static void inserisciConto() throws DaoException {
        Conti c = new Conti();
        System.out.println("Inserisci CIN:");
        c.setCIN(sc.nextLine());
        System.out.println("Inserisci ABI:");
        c.setABI(sc.nextInt());
        sc.nextLine();
        System.out.println("Inserisci CAB:");
        c.setCAB(sc.nextInt());
        sc.nextLine();
        System.out.println("Inserisci nomeTitolare:");
        c.setNomeTitolare(sc.nextLine());
        System.out.println("Inserisci cognomeTitolare:");
        c.setCognomeTitolare(sc.nextLine());
        System.out.println("Inserisci codiceFiscaleTitolare:");
        c.setCodiceFiscaleTitolare(sc.nextLine());
        dc.create(new Conti(c.getCIN().toUpperCase(), c.getABI(), c.getCAB(), c.getNomeTitolare(), c.getCognomeTitolare(), c.getCodiceFiscaleTitolare().toUpperCase()));
    }
}