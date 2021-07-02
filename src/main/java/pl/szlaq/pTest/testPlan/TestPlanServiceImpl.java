package pl.szlaq.pTest.testPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestPlanServiceImpl implements TestPlanService{

    @Autowired
    TestPlanRepository testPlanRepository;

    @Override
    public List<TestPlan> getAllTestPlans() {
        return null;
    }

    @Override
    public TestPlan getTestPlanById(long id) {
        return null;
    }

    public List<TestPlan> getTestPlansInProject(long projectId) {
        return testPlanRepository.findAll().stream()
                .filter(element -> element.getProjectId() == projectId)
                .map(TestPlan::new)
                .toList();
    }

    @Override
    public TestPlan addTestPlan(TestPlanMapper testPlanMapper) {
        TestPlanDTO newTestPlan = new TestPlanDTO(testPlanMapper.name(),testPlanMapper.projectId());
        if(!testPlanMapper.description().isBlank()) {
            newTestPlan.setDescription(testPlanMapper.description());
        }
        testPlanRepository.save(newTestPlan);
        return new TestPlan(newTestPlan);
    }
}
