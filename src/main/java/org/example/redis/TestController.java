package org.example.redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/testCluster")
    public void testCluster() {
        CacheManager.set("a", "a");
        CacheManager.set("name", "niuniu");
        String name = CacheManager.get("name");
        System.out.println(name);
        System.out.println(CacheManager.get("a"));


//                Main t1 = new Main();
//                t1.setName("thread1");
//                t1.start();


    }
}
