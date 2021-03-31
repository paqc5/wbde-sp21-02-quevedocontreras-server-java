package com.example.wbdesp2102quevedocontrerasserverjava.services;

import com.example.wbdesp2102quevedocontrerasserverjava.models.Widget;
import com.example.wbdesp2102quevedocontrerasserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  /**  
   * private List<Widget> widgets = new ArrayList<>();
   * {
   *   Widget w1 = new Widget(123l, "60514e91995a8b0017af1d0e", "HEADING", 1, "Heading Test 1");
   *   Widget w2 = new Widget(234l, "60514e91995a8b0017af1d0e", "PARAGRAPH", 1, "Paragraph Test 1");
   *   Widget w3 = new Widget(345l, "605154765e8e300017eedd24", "HEADING", 1, "Heading Test 1");
   *   Widget w4 = new Widget(456l, "605154765e8e300017eedd24", "PARAGRAPH", 1, "Paragraph Test 1");
   *   Widget w5 = new Widget(567l, "605154765e8e300017eedd24", "HEADING", 2, "Heading Test 2");
   *   Widget w6 = new Widget(678l, "605154765e8e300017eedd24", "PARAGRAPH", 1, "Paragraph Test 2");

   *   widgets.add(w1);
   *   widgets.add(w2);
   *   widgets.add(w3);
   *   widgets.add(w4);
   *   widgets.add(w5);
   *   widgets.add(w6);
   * }
   */

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    return repository.save(widget);
    /**
     * widget.setId((new Date()).getTime()); widgets.add(widget); return widget;
     */
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
    /**
     * List<Widget> tmp = new ArrayList<>(); if(topicId.equals("undefined")) {
     * return tmp; } for (Widget w :widgets) { if (w.getTopicId().equals(topicId)) {
     * tmp.add(w); } } return tmp;
     */
  }

  public Integer updateWidget(Long widgetId, Widget widget) {
    if (widgetId == null) {
      return 0;
    }

    Widget originalWidget = null;
    Optional<Widget> optValue = repository.findById(widgetId);

    if (optValue.isPresent()) {
      originalWidget = optValue.get();

      if (widget.getType() != null) {
        originalWidget.setType(widget.getType());
      }
      if (widget.getWidgetOrder() != null) {
        originalWidget.setWidgetOrder(widget.getWidgetOrder());
      }
      if (widget.getText() != null) {
        originalWidget.setText(widget.getText());
      }
      if (widget.getSrc() != null) {
        originalWidget.setSrc(widget.getSrc());
      }
      if (widget.getSize() != null) {
        originalWidget.setSize(widget.getSize());
      }
      if (widget.getWidth() != null) {
        originalWidget.setWidth(widget.getWidth());
      }
      if (widget.getHeight() != null) {
        originalWidget.setHeight(widget.getHeight());
      }
      if (widget.getCssClass() != null) {
        originalWidget.setCssClass(widget.getCssClass());
      }
      if (widget.getStyle() != null) {
        originalWidget.setStyle(widget.getStyle());
      }
      if (widget.getValue() != null) {
        originalWidget.setValue(widget.getValue());
      }
      if (widget.getOrdered() != null) {
        originalWidget.setOrdered(widget.getOrdered());
      }

      repository.save(originalWidget);
    }
    return 1;

    /**
     * for(int i = 0; i < widgets.size(); i++) {
     * if(widgets.get(i).getId().toString().compareTo(widgetId) == 0) {
     * widgets.set(i, widget); return 1; } } return 0;
     */
  }

  public Integer deleteWidget(Long widgetId) {
    repository.deleteById(widgetId);
    return 1;
    /**
     * for (int i = 0; i < widgets.size(); i++) { if
     * (widgets.get(i).getId().toString().compareTo(widgetId) == 0) {
     * widgets.remove(i); return 1; } } return 0;
     */
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
  }

  public Widget findWidgetById(Long widgetId) {
    Widget widget = null;

    if (widgetId == null) {
      return widget;
    }

    Optional<Widget> optValue = repository.findById(widgetId);
    if (optValue.isPresent()) {
      widget = optValue.get();
      return widget;
    } else {
      return widget;
    }
  }
}
