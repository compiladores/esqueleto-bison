package ar.uba.fi.compiladores.Lang3;

public class BrainforkHelper {
    protected String comma(String s){
        return s;
    }
    protected String tuple(String exp, String div){
        return "("+exp+","+div+")";
    }
    protected String division(String div1, String div2){
        return "["+div1+"/"+div2+"]";
    }
    protected String opposite(String s){
        return "1/"+s;
    }
}