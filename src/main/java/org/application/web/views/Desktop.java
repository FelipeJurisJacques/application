package org.application.web.views;

import org.application.web.elements.Body;
import org.application.web.widgets.Widget;
// import org.application.web.elements.Element;
import org.application.web.elements.Document;

public class Desktop {
        public Desktop() {
                Body body = Document.getBody();
                // body.setChildren(new Element[] {
                // Widget.create("div").setClass("bar"),
                // Widget.create("div").setClass("start_menu").setChildren(new Element[] {
                // Widget.create("ul").setChildren(new Element[] {
                // Widget.create("li").setChildren(new Element[] {
                // Widget.create("button")
                // .setClass("explorer")
                // .setContent("Explorador de arquivos"),
                // }),
                // }),
                // }),
                // Widget.create("footer").setClass("task_bar").setChildren(new Element[] {
                // Widget.create("button").setClass("start").setTitle("Start"),
                // }),
                // });
                body.append(Widget.create("div").setClass("bar"));
                body.append(
                                Widget.create("div").setClass("start_menu").append(
                                                Widget.create("ul").append(
                                                                Widget.create("li").append(
                                                                                Widget.create("button")
                                                                                                .setClass("explorer")
                                                                                                .setContent("Explorador de arquivos")))));
                body.append(
                                Widget.create("footer").setClass("task_bar").append(
                                                Widget.create("button").setClass("start").setTitle("Start")));
        }
}
