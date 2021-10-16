package ar.uba.fi.compiladores.Lang4;

public class RainforkHelper {
    protected SemVal comma(SemVal s){
        return s;
    }
    protected SemVal tuple(SemVal exp, SemVal div){
        return new SemVal(exp,div,null);
    }
    protected SemVal division(SemVal div1, SemVal div2){
        if(div1.getValue()!=null && div2.getValue()!=null){
            return new SemVal(null,null,div1.getValue().doubleValue()/div2.getValue().doubleValue());
        }
        SemVal left = new SemVal(null,null,div1.getLeft().getValue().doubleValue()/div2.getLeft().getValue().doubleValue());
        SemVal right = new SemVal(null,null,div1.getRight().getValue().doubleValue()/div2.getRight().getValue().doubleValue());
        return new SemVal(left,right,null);
    }
    protected SemVal opposite(SemVal s){
        if(s.getValue()==null){
            SemVal left = new SemVal(null,null,1/s.getLeft().getValue().doubleValue());
            SemVal right = new SemVal(null,null,1/s.getRight().getValue().doubleValue());
            return new SemVal(left,right,null);
        }
        return new SemVal(null,null,1/s.getValue().doubleValue());
    }
    protected SemVal zero(){
        return new SemVal(new SemVal(null,null,0),new SemVal(null,null,0),0);
    }

}