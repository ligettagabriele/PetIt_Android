package com.example.galig.petit.PetItTESTS.v1.FeedAndMap.ListView;

public class ElementoLista {

    private String nomeSegnalazione;
    private String razzaSegnalazione;
    private String posizioneSegnalazione;

    public ElementoLista() {
    }

    public ElementoLista(String nomeSegnalazione, String razzaSegnalazione, String posizioneSegnalazione) {
        this.nomeSegnalazione = nomeSegnalazione;
        this.razzaSegnalazione = razzaSegnalazione;
        this.posizioneSegnalazione = posizioneSegnalazione;
    }

    public String getNomeSegnalazione() {
        return nomeSegnalazione;
    }

    public void setNomeSegnalazione(String nomeSegnalazione) {
        this.nomeSegnalazione = nomeSegnalazione;
    }

    public String getRazzaSegnalazione() {
        return razzaSegnalazione;
    }

    public void setRazzaSegnalazione(String razzaSegnalazione) {
        this.razzaSegnalazione = razzaSegnalazione;
    }

    public String getPosizioneSegnalazione() {
        return posizioneSegnalazione;
    }

    public void setPosizioneSegnalazione(String posizioneSegnalazione) {
        this.posizioneSegnalazione = posizioneSegnalazione;
    }
}
