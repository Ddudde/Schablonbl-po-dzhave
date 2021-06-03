package com.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostServTest {
    private PostOfficeController postOfficeController;

    @Autowired
    public void setPostOfficeController(PostOfficeController postOfficeController) {
        this.postOfficeController = postOfficeController;
    }

    @Test
    public void getAllPosts() {
        Assert.notEmpty(postOfficeController.getAll(), "Хоба");
    }
}
