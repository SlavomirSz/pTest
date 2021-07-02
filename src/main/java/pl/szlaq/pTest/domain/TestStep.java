package pl.szlaq.pTest.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TestStep  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String name;

    protected String description;

    private int caseId;

}
