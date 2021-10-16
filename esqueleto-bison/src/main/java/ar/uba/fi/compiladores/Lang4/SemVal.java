package ar.uba.fi.compiladores.Lang4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SemVal {
    @Getter
    private SemVal left;    
    @Getter
    private SemVal right;    
    @Getter
    private Number value;
    
    @Override
    public String toString(){
        if(value==null){
            return "("+left.toString()+","+right.toString()+")";
        }
        return value.toString();
    }
}
