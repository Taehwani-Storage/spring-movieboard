package com.bit.movieboard.controller;

import com.bit.movieboard.model.MemberDTO;
import com.bit.movieboard.model.MovieDTO;
import com.bit.movieboard.service.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movieboard/")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("showAll")
    public String showAll() {
        return "redirect:/moviebard/showAll/1";
    }

    @GetMapping("showOne/{id}")
    public String showOne(@PathVariable int id, Model model, HttpSession session) {
        MemberDTO logIn = (MemberDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }
        MovieDTO movieDTO = movieService.selectOne(id);
        model.addAttribute("movieDTO", movieDTO);

        return "/movieboard/showOne";
    }

    @GetMapping("write")
    public String write(HttpSession session) {

    }

}
