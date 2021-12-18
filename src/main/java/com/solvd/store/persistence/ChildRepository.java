package com.solvd.store.persistence;

import com.solvd.store.domain.Child;
import org.apache.ibatis.annotations.Param;

public interface ChildRepository {

    void create (Child child);

}
