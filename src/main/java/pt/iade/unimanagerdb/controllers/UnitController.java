package pt.iade.unimanagerdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanagerdb.models.Unit;
import pt.iade.unimanagerdb.models.repositories.UnitRepository;

@RestController
@RequestMapping(path = "/api/units")
public class UnitController {
    private Logger logger = LoggerFactory.getLogger(UnitController.class);
    @Autowired
    private UnitRepository unitRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Unit> getUnits() {
        logger.info("Sending all units");
        return unitRepository.findAll();
    }
}
