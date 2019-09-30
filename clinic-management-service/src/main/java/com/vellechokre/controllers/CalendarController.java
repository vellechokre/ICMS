package com.vellechokre.controllers;

// package com.dev.controller;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import org.json.JSONArray;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.ModelAndView;
//
// import com.dev.bo.Events;
// import com.dev.entity.UserLogin;
//
// @Controller
// public class CalendarController {
//
// @RequestMapping(value = "/myAppointment", method = RequestMethod.GET)
// public ModelAndView myAppointment(@ModelAttribute("user") final UserLogin user) {
//
// System.out.println("inside reviewLead:::::::" + user.getUserName());
// final Events event1 = new Events("All Day Event", "2017-08-07");
// final Events event2 = new Events("nishant", "2017-08-07T10:30:00");
// final List<Events> events = new ArrayList<>();
// events.add(event1);
// events.add(event2);
// final ModelAndView model = new ModelAndView("myAppointment", "command", new UserLogin());
// final JSONArray eventsJson = new JSONArray(events);
// model.addObject("events", eventsJson);
// return model;
// }
// }
