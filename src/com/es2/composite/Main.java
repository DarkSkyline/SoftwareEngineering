package com.es2.composite;

public class Main {

    public static void main(String[] args){
        SubMenu m = new SubMenu();
        m.setLabel("Inserir");

        SubMenu client = new SubMenu();
        client.setLabel("Cliente");
        m.addChild(client);

        CompositePattern entreprise = new CompositePattern();
        entreprise.setLabel("Empresarial");
        entreprise.setUrl("http://www.abc.pt/empresarial");

        client.addChild(entreprise);

        SubMenu particular = new SubMenu();
        particular.setLabel("Particular");
        client.addChild(particular);

        CompositePattern withVat = new CompositePattern();
        withVat.setLabel("Particular com contribuinte");
        withVat.setUrl("http://www.abc.pt/pcc");
        particular.addChild(withVat);

        m.showOptions();
    }
}
