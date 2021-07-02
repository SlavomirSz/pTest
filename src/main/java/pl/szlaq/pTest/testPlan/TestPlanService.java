package pl.szlaq.pTest.testPlan;

import java.util.List;

public interface TestPlanService {

    List<TestPlan> getAllTestPlans();

    TestPlan getTestPlanById(long id);

    List<TestPlan> getTestPlansInProject(long projectId);

    TestPlan addTestPlan(TestPlanMapper testPlanMapper);
}
