package pl.szlaq.pTest.testPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test-plan")
public class TestPlanController {

    @Autowired
    TestPlanService testPlanService;

    @PostMapping("/")
    TestPlan createTestPlan(@RequestBody TestPlanMapper testPlanMapper) {
        return testPlanService.addTestPlan(testPlanMapper);
    }
}
