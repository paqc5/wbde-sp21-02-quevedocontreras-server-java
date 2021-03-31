package com.example.wbdesp2102quevedocontrerasserverjava.models;
import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String topicId;
  private String type;
  private Integer widgetOrder;
  private String text;
  private String src;
  private Integer size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private Boolean ordered;

  public Widget(Long id, String topicId, String type, Integer widgetOrder, String text, String src, Boolean ordered) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.src = src;
    this.ordered = ordered;
    
  }

  public Widget() {

  }
  
  public Widget(Widget widget) {
    this.id = widget.id;
    this.topicId = widget.topicId;
    this.type = widget.type;
    this.widgetOrder = widget.widgetOrder;
    this.text = widget.text;
    this.src = widget.src;
    this.ordered = widget.ordered;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTopicId() {
    return topicId;
  }
  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public Integer getSize() {
    return size;
  }
  public void setSize(Integer size) {
    this.size = size;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }
}
