package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.repository.CommentRepository;
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

    //@GetMapping
    ResponseEntity<List<Comment>> readAllComments(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(commentService.findAll(page).getContent());
    }

    @GetMapping
    public String list(Model model, Pageable page) {
        model.addAttribute("comments", commentService.findAll(page));
        return "comments";
    }

    @PostMapping
    ResponseEntity<Comment> createComment(@RequestBody @Valid Comment toAdd){
        logger.info("Dodano komentarz!");
        commentService.save(toAdd);
        return ResponseEntity.created(URI.create("/" + toAdd.getId())).body(toAdd);
    }

}
