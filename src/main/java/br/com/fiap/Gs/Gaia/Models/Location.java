package br.com.fiap.Gs.Gaia.Models;

import br.com.fiap.Gs.Gaia.Enum.TypeStation;
import br.com.fiap.Gs.Gaia.Enum.TypeStatusLocation;

import java.time.LocalDate;
import java.util.List;

public class Location {

    private Long idLocation;

    private TypeStation state;
    private String city;

    private LocalDate startAccident;
    private LocalDate endAccident;

    private TypeStatusLocation statusLocation;

    private List<Requestion> requestionList;
}
