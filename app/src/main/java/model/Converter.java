package model;

/**
 * Created by wilder on 19/06/15.
 */
public class Converter {

    public enum TypeTemperature {C,F,K}
    private TypeTemperature typeTemperature;

    public Converter(){

    }

    public Double convert(TypeTemperature typeTemperatureInput, TypeTemperature typeTemperatureOutput, double x){

        Double result = null;

        switch (typeTemperatureInput){
            case C:
                result = convertCTo(typeTemperatureOutput, x);
                break;
            case F:
                result = convertFTo(typeTemperatureOutput, x);
                break;
            case K:
                result = convertKTo(typeTemperatureOutput, x);
                break;
        }
        return result;
    }

    public Double convertCTo(TypeTemperature typeTemperature, double x){

        Double result = null;

        switch (typeTemperature){
            case F:
                result = converterCtoF(x);
                break;
            case K:
                result = converterCtoK(x);
                break;
        }
        return result;
    }

    public Double convertFTo(TypeTemperature typeTemperature, double x){

        Double result = null;

        switch (typeTemperature){
            case C:
                result = converterFtoC(x);
                break;
            case K:
                result = converterFtoK(x);
                break;
        }
        return result;
    }

    public Double convertKTo(TypeTemperature typeTemperature, double x){

        Double result = null;

        switch (typeTemperature){
            case F:
                result = converterKtoC(x);
                break;
            case C:
                result = converterKtoF(x);
                break;
        }

        return  result;
    }

    public double converterCtoF(double x){
        return (9 * x) / 5 + 32;
    }

    public double converterCtoK(double x){
        return x + 273;
    }

    public double converterFtoC(double x){
        return 5 * (x - 32) / 9;
    }

    public double converterFtoK(double x){
        return 5 * (x - 32) / 9 + 273;
    }

    public double converterKtoC(double x){
        return x - 273 ;
    }

    public double converterKtoF(double x){
        return 9 * (x - 273) / 5 + 32;
    }

    public TypeTemperature getTypeTemperature() {
        return typeTemperature;
    }

    public void setTypeTemperature(TypeTemperature typeTemperature) {
        this.typeTemperature = typeTemperature;
    }
}
