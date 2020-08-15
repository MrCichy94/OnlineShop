package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/all")
    ResponseEntity<List<Comment>> readAllComments() {
        logger.info("Wczytano komentarze");
        return ResponseEntity.ok(commentService.readAllComments());
    }


    @PostMapping("/all")
    ResponseEntity<Comment> createComment(@RequestBody @Valid Comment toAdd){
        logger.info("Dodano komentarz!");
        commentService.addComment(toAdd);
        return ResponseEntity.created(URI.create("/" + toAdd.getId())).body(toAdd);
    }

    @GetMapping
    public String add(Model model) {
        model.addAttribute("comments", commentService.readAllComments());
        model.addAttribute("comment", new Comment());
        return "comments";
    }

    @PostMapping
    public String processAdd(@ModelAttribute("comment") @Valid Comment comment, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("comments", commentService.readAllComments());
            return "comments";
        }
        commentService.addComment(comment);
        model.addAttribute("comments", commentService.readAllComments());
        return "comments";
    }

}