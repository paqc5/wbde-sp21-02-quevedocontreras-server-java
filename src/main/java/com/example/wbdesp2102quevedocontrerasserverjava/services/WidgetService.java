package com.example.wbdesp2102quevedocontrerasserverjava.services;

import com.example.wbdesp2102quevedocontrerasserverjava.models.Widget;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

  private List<Widget> widgets = new ArrayList<>();
  {
    Widget w1 = new Widget(123l, "60514e91995a8b0017af1d0e", "HEADING", 1, "Heading Test 1");
    Widget w2 = new Widget(234l, "60514e91995a8b0017af1d0e", "PARAGRAPH", 1, "Paragraph Test 1");
    Widget w3 = new Widget(345l, "605154765e8e300017eedd24", "HEADING", 1, "Heading Test 1");
    Widget w4 = new Widget(456l, "605154765e8e300017eedd24", "PARAGRAPH", 1, "Paragraph Test 1");
    Widget w5 = new Widget(567l, "605154765e8e300017eedd24", "HEADING", 2, "Heading Test 2");
    Widget w6 = new Widget(678l, "605154765e8e300017eedd24", "PARAGRAPH", 1, "Paragraph Test 2");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
    widgets.add(w6);
  }

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    widget.setId((new Date()).getTime());
    widgets.add(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> tmp = new ArrayList<>();
    if(topicId.equals("undefined")) {
      return tmp;
    }
    for (Widget w : widgets) {
      if (w.getTopicId().equals(topicId)) {
        tmp.add(w);
      }
    }
    return tmp;
  }

  public Integer updateWidget(String widgetId, Widget widget) {
    for(int i = 0; i < widgets.size(); i++) {
      if(widgets.get(i).getId().toString().compareTo(widgetId) == 0) {
        widgets.set(i, widget);
        return 1;
      }
    }
    return 0;
  }

  public Integer deleteWidget(String widgetId) {
    for (int i = 0; i < widgets.size(); i++) {
      if (widgets.get(i).getId().toString().compareTo(widgetId) == 0) {
        widgets.remove(i);
        return 1;
      }
    }
    return 0;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }
}
