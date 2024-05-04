package main;

import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;
import interfaces.funcionales.Converter;

public class main {
    public static void main(String[] args) {
        FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);

        Converter<FelinoDomestico, FelinoSalvaje> converterDomesticoASalvaje = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        if (Converter.isNotNull(gato)) {
            FelinoSalvaje felino1 = converterDomesticoASalvaje.convert(gato);
            converterDomesticoASalvaje.mostrarObjeto(felino1);
        }

        FelinoSalvaje felino2 = new FelinoSalvaje("Tanner", (byte)20, 186f);

        Converter<FelinoSalvaje, FelinoDomestico> converterSalvajeADomestico = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());

        if (Converter.isNotNull(felino2)) {
            FelinoDomestico felinoConvertido = converterSalvajeADomestico.convert(felino2);
            converterSalvajeADomestico.mostrarObjeto(felinoConvertido);
        }
    }
}