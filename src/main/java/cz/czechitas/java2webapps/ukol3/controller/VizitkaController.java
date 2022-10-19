package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller

public class VizitkaController {
    private List<Vizitka> seznamVizitek = List.of(

            new Vizitka("Petra Nováková", "CZC", "Pražská 13", "Brno 12000", "petra.novakova@gmail.com",
                    "723 777 777", "www.petnov.cz"),
            new Vizitka("Petr Svoboda", "Dražice, s.r.o", "náměstí Míru 12", "Praha 14000", "",
                    "724 777 777", "www.petsvo.cz"),
            new Vizitka("Jana Novotná", "Šlapeto, a.s.", "Nová 35", "Olomouc 15000", "jananovotna@seznam.cz",
                    "", "www.jannov.cz"),
            new Vizitka("Lukáš Smejkal", "Dobrá strava", "Šafaříkova 10", "Ostrava 16000", "lukassmejkal@tiscali.cz",
                    "725 777 777", "")

    );

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("vizitka", seznamVizitek);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("vizitka", seznamVizitek.get(id));
        return modelAndView;
    }
}
