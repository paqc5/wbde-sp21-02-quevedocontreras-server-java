package com.example.wbdesp2102quevedocontrerasserverjava.repositories;
import java.util.List;
import com.example.wbdesp2102quevedocontrerasserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Long> {
  
  @Query(value = "SELECT * FROM widgets WHERE topic_id =:tid order by id", nativeQuery = true)
  public List<Widget> findWidgetsForTopic(@Param("tid") String topicId);
}
