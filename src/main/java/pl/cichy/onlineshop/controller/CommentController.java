package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.service.CommentService;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;


@Controller
@RequestMapping(value = "/comments")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /*
    @GetMapping("/all")
    ResponseEntity<List<Comment>> readAllComments(Pageable page) {
        logger.info("Wczytano komentarze");
        return ResponseEntity.ok(commentService.findAll(page));
    }

     */

    @PostMapping("/all")
    ResponseEntity<Comment> createComment(@RequestBody @Valid Comment toAdd){
        logger.info("Dodano komentarz!");
        commentService.save(toAdd);
        return ResponseEntity.created(URI.create("/" + toAdd.getId())).body(toAdd);
    }



    @GetMapping
    public String add(Model model, Pageable page) {
        model.addAttribute("comments", commentService.findAll(page));
        model.addAttribute("comment", new Comment());
        return "comments";
    }

    @PostMapping
    public String processAdd(@ModelAttribute("comment") @Valid Comment comment, BindingResult bindingResult, Model model, Pageable page){
        if (bindingResult.hasErrors()){
            model.addAttribute("comments", commentService.findAll(page));
            return "comments";
        }
        commentService.save(comment);
        model.addAttribute("comments", commentService.findAll(page));
        return "comments";
    }

}