package com.javacodegeeks.snippets.enterprise;

import java.util.Date;
import java.util.List;

public class ProcContainer {

    private Long id;
    private List<Proc> procList;

    public List<Proc> getProcList() {
        return procList;
    }

    public void setProcList(List<Proc> procList) {
        this.procList = procList;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
