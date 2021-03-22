package com.example.wbdesp2102quevedocontrerasserverjava.controllers;

import java.util.List;
import com.example.wbdesp2102quevedocontrerasserverjava.models.Widget;
import com.example.wbdesp2102quevedocontrerasserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

  @Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopic
  (@PathVariable("tid") String topicId, @RequestBody Widget widget) {
    return service.createWidget(topicId, widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic
  (@PathVariable("tid") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget
  (@PathVariable("wid") String widgetId, 
  @RequestBody Widget widget) {
    return service.updateWidget(widgetId, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public Integer deleteWidget
  (@PathVariable("wid") String widgetId) {
    return service.deleteWidget(widgetId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }
}
