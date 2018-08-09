package com.test.searchapp.dataservice.repository;

import java.util.List;


import com.test.searchapp.dataservice.dbmodel.orm.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository  extends CrudRepository<Topic, Long> {

        List<Topic> findByDescriptionLikeIgnoreCase(String searchString);

}
