package cadastro.view.util;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;


public class LimitaCaracteres extends PlainDocument{
    
    public enum TipoEntrada {
        NUMEROINTEIRO, NUMERODECIMAL, NOME, EMAIL, DATA, ALFANUMERICO;
    };
    
    private int qtdCaracteres;
    private TipoEntrada tpEntrada;

    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        if (string == null || getLength() == qtdCaracteres){
            return;
        }
        int totalCarac = getLength() + string.length();
        // filtro de caracteres
        String regex = "";
        switch(tpEntrada){
            case NUMEROINTEIRO: regex = "[^0-9]"; break;
            case NUMERODECIMAL: regex = "[^0-9,.]"; break;
            case NOME:          regex = "[^\\p{IsLatin} ]"; break;
            case ALFANUMERICO:  regex = "[^\\p{IsLatin},^0-9,',�,.\\- ]"; break;
            case EMAIL:         regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
            case DATA:          regex = "[^0-9/]"; break;
        }
        // fazendo a substitui��o
        string = string.replaceAll(regex, "");
        
        if (totalCarac <= qtdCaracteres){
            super.insertString(i, string, as); //To change body of generated methods, choose Tools | Templates.
        }else{
            String nova = string.substring(0, qtdCaracteres);
            super.insertString(i, nova, as);
        }
    } 
}
