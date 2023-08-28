package Conto.Dto;

public class Conti {
    private String CIN;
    private int ABI;
    private int CAB;
    private long numeroConto;
    private String nomeTitolare;
    private String cognomeTitolare;
    private String codiceFiscaleTitolare;

    public Conti() {
    }

    public Conti(String CIN, int ABI, int CAB, long numeroConto, String nomeTitolare, String cognomeTitolare, String codiceFiscaleTitolare) {
        this.CIN = CIN;
        this.ABI = ABI;
        this.CAB = CAB;
        this.numeroConto = numeroConto;
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
        this.codiceFiscaleTitolare = codiceFiscaleTitolare;
    }

    public Conti(String CIN, int ABI, int CAB, String nomeTitolare, String cognomeTitolare, String codiceFiscaleTitolare) {
        this.CIN = CIN;
        this.ABI = ABI;
        this.CAB = CAB;
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
        this.codiceFiscaleTitolare = codiceFiscaleTitolare;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        if(CIN.length()==1) {
            this.CIN = CIN;
        }else {
            System.out.println("errore, inserisci massimo un simbolo");
        }
    }

    public int getABI() {
        return ABI;
    }

    public void setABI(int ABI) {
        if( (int)(Math.log10(ABI) + 1)==5) {
            this.ABI = ABI;
        }else {
        System.out.println("inserisci 5 numeri");
    }
    }

    @Override
    public String toString() {
        return "Conto:" +
                "CIN='" + CIN + '\'' +
                ", ABI=" + ABI +
                ", CAB=" + CAB +
                ", numero Conto=" + numeroConto +
                ", nome Titolare='" + nomeTitolare + '\'' +
                ", cognome Titolare='" + cognomeTitolare + '\'' +
                ", codice Fiscale Titolare='" + codiceFiscaleTitolare + '\'' +
                '\n';
    }

    public long getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(long numeroConto) {
        this.numeroConto = numeroConto;
    }

    public int getCAB() {
        return CAB;
    }

    public void setCAB(int CAB) {
        if( (int)(Math.log10(CAB) + 1)==5) {
        this.CAB = CAB;}
        else {
            System.out.println("inserisci 5 numeri");
        }

    }

    public String getNomeTitolare() {
        return nomeTitolare;
    }

    public void setNomeTitolare(String nomeTitolare) {
        this.nomeTitolare = nomeTitolare;
    }

    public String getCognomeTitolare() {
        return cognomeTitolare;
    }

    public void setCognomeTitolare(String cognomeTitolare) {
        this.cognomeTitolare = cognomeTitolare;
    }

    public String getCodiceFiscaleTitolare() {
        return codiceFiscaleTitolare;
    }

    public void setCodiceFiscaleTitolare(String codiceFiscaleTitolare) {
        if(codiceFiscaleTitolare.length()==16) {
        this.codiceFiscaleTitolare = codiceFiscaleTitolare;
    }else {
            System.out.println("inserisci 16 simboli");
        }
    }
}
