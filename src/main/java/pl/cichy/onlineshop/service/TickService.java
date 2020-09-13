package pl.cichy.onlineshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.Comment;
import pl.cichy.onlineshop.model.Tick;
import pl.cichy.onlineshop.model.repository.CommentRepository;
import pl.cichy.onlineshop.model.repository.TickRepository;

import java.util.Optional;

@Service
public class TickService {

    private final TickRepository tickRepository;

    public TickService(final TickRepository tickRepository) {
        this.tickRepository = tickRepository;
    }

    public Optional<Tick> findById(Integer id){
        return tickRepository.findById(id);
    }

    public Page<Tick> findAll(Pageable page){
        return tickRepository.findAll(page);
    }

    public void deleteById(Integer id){
        tickRepository.deleteById(id);
    }

    public Tick save (Tick entity){
        return tickRepository.save(entity);
    }

    public boolean existsById(Integer id){
        return tickRepository.existsById(id);
    }

}
