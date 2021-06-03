package com.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DepServTest {

    private DepartureController departureController;

    @Autowired
    public void setDepartureController(DepartureController departureController) {
        this.departureController = departureController;
    }

    @Test
    public void getAllDeps() {
        Assert.notEmpty(departureController.getAll(), "Хоба");
    }
}
