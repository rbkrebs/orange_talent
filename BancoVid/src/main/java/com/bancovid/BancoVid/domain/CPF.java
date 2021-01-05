package com.bancovid.BancoVid.domain;

import com.bancovid.BancoVid.exceptions.ClienteCivilException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPF {

    private static final Pattern p = Pattern.compile("([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\-]?[0-9]{2})|([0-9]{11})");
    private static  final String delimiters = "[\\-\\.]?";

    public static boolean validaCpf(String cpf){

        Matcher m = p.matcher(cpf);

        if(m.find()){
            return true;
        }

        return false;

    }

    public static String covertCpf(String cpf){

        if(validaCpf(cpf)){
            return String.join("",cpf.split(delimiters));
        }

        throw new IllegalArgumentException(ClienteCivilException.FORMATED_CPF);

    }


}
